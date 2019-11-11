package net.fsd.training.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.fsd.entity.Training;
import net.fsd.model.TrainingDtls;
import net.fsd.training.dao.TrainingRepository;

@Service(value = "trainingService")
public class TrainingServiceImpl implements ITrainingService {
	@Autowired
	TrainingRepository trainingRepository;

	@Override
	public Training addTraining(Training tr) {
		return trainingRepository.saveAndFlush(tr);
	}

	@Override
	public void updateTraining(Training tr) {
		trainingRepository.saveAndFlush(tr);
	}

	@Override
	public void deleteTraining(long id) {
		trainingRepository.deleteById(id);
	}

	public TrainingDtls findById(long id) {
		List queryList = trainingRepository.findTrainingById(id);
		if (queryList.size() > 0) {
			Object[] arr = (Object[]) queryList.get(0);
			TrainingDtls tmp = toTrainingDtls(arr);
			return tmp;
		}
		return null;
	}

	@Override
	public List<TrainingDtls> listTraining() {
		List queryList = trainingRepository.findAllTraining();
		List ret = new ArrayList();
		queryList.forEach(objs -> {
			Object[] arr = (Object[]) objs;
			TrainingDtls tmp = toTrainingDtls(arr);
			ret.add(tmp);
		});
		return ret;
	}

	private TrainingDtls toTrainingDtls(Object[] arr) {
		TrainingDtls td = new TrainingDtls();
		td.setId((Long) arr[0]);
		td.setStatus((String) arr[1]);
		td.setProgress((Integer) arr[2]);
		td.setFees((Float) arr[3]);
		td.setCommissionAmout((Float) arr[4]);

		td.setRating((Integer) arr[5]);
		td.setStartDate((String) arr[6]);
		td.setEndDate((String) arr[7]);
		td.setStartTime((String) arr[8]);
		td.setEndTime((String) arr[9]);
		td.setAmountReceived((Float) arr[10]);
		td.setRazorpayPaymentId((String) arr[1]);
		td.setUserName((String) arr[12]);
		td.setMentorName((String) arr[13]);
		td.setSkillName((String) arr[14]);
		td.setDesc((String) arr[15]);
		return td;
	}

}
