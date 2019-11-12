package net.fsd.training.service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import net.fsd.comm.log.LogInterceptor;
import net.fsd.entity.Training;
import net.fsd.training.dao.TrainingRepository;

@Service
@EnableScheduling
public class ProgressCalculator {

	Logger log = LoggerFactory.getLogger(ProgressCalculator.class);

	public static BigDecimal P_25 = new BigDecimal(0.25);
	public static BigDecimal P_50 = new BigDecimal(0.50);
	public static BigDecimal P_75 = new BigDecimal(0.75);
	public static BigDecimal P_100 = new BigDecimal(1.0);
	public static BigDecimal M_100 = new BigDecimal(100);

	@Autowired
	TrainingRepository trainingRepository;

	@Scheduled(cron = "0 30 11 * * ?")
	@Scheduled(fixedRate = 5000)
	public void checkTrainingProgress() {
		List<Training> queryList = trainingRepository.findAllTraining();
		for (int i = 0; i < queryList.size(); i++) {
			Training t = queryList.get(i);
			try {
				updateProgress(t);
			} catch (Exception ex) {
				log.error(ex.getMessage());
			}
		}
	}

	public void updateProgress(Training t) throws ParseException {
		String start = t.getStartDate();
		String end = t.getEndDate();
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		Date oStart = df.parse(start);
		Date oEnd = df.parse(end);
		Date cur = new Date();
		cur.setHours(0);
		cur.setMinutes(0);
		cur.setSeconds(0);
		long period = (oEnd.getTime() - oStart.getTime()) / (24 * 3600 * 1000);
		long days = (cur.getTime() - oStart.getTime()) / (24 * 3600 * 1000);
		BigDecimal oPeriod = new BigDecimal(period);
		BigDecimal oDays = new BigDecimal(days);
		BigDecimal oPer = oDays.divide(oPeriod, 6, BigDecimal.ROUND_HALF_UP);

		if (oPer.equals(P_25) || oPer.equals(P_50) || oPer.equals(P_75) || oPer.equals(P_100)) {
			oPer.multiply(M_100).setScale(2, BigDecimal.ROUND_HALF_UP);
			t.setProgress(oPer.intValue());
			trainingRepository.save(t);
		}
	}

	@Scheduled(cron = "0 30 11 * * ?")
	// @Scheduled(fixedRate = 5000)
	public void checkProgress() {
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^start DateCalculator " + new Date());
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date start = df.parse("2019-08-01");
			Date end = df.parse("2019-12-01");
			long period = (end.getTime() - start.getTime()) / (24 * 3600 * 1000);
			Date cur = new Date();
			cur.setHours(0);
			cur.setMinutes(0);
			cur.setSeconds(0);
			long days = (cur.getTime() - start.getTime()) / (24 * 3600 * 1000);
			BigDecimal oPeriod = new BigDecimal(period);
			BigDecimal oDays = new BigDecimal(days);
			BigDecimal oPer = oDays.divide(oPeriod, 6, BigDecimal.ROUND_HALF_UP);
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>training:" + period + ", completed=" + days);
			System.out.println(
					">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>training:" + period + ", completed" + days + ", percent:" + oPer);

			if (oPer.equals(P_25) || oPer.equals(P_50) || oPer.equals(P_75) || oPer.equals(P_100)) {

			}

		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

}
