package net.fsd.training;

import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import net.fsd.entity.Training;

public class TrainingManager {
	public static void createTrainingHibernate(MockHttpServletRequestBuilder request) {
		Training tr = new Training();
		tr.setMentorId(3L);
		tr.setSkillId(1L);
		tr.setProgress(10);
		tr.setAmountReceived(0.3F);
		tr.setCommissionAmount(03F);
		tr.setStartDate("2019/09/01");
		tr.setEndDate("2019/09/09");
		tr.setStartTime("09:00:00");
		tr.setEndTime("11:00:00");
		tr.setFees(1000F);
		tr.setStatus("normal");
		tr.setRazorpayPaymentId("123456");
		tr.setDesc("skill-Hibernate-1-mentor-3");

		request.param("mentorId", "3");
		request.param("skillId", "1");
		request.param("progress", "10");
		request.param("amountReceive", "0.3");
		request.param("commissionAmount", "0.3");
		request.param("startDate", "2019/09/01");
		request.param("endDate", "2019/09/09");
		request.param("startTime", "09:00:00");
		request.param("endTime", "11:00:00");
		request.param("fees", "1000");
		request.param("status", "normal");
		request.param("razorpayPaymentId", "1111111");
		request.param("desc", "skill-Hibernate-1-mentor-3");
	}

	public static void createTrainingMySQL(MockHttpServletRequestBuilder request) {
		Training tr = new Training();
		tr.setMentorId(3L);
		tr.setSkillId(2L);
		tr.setProgress(20);
		tr.setAmountReceived(0.3F);
		tr.setCommissionAmount(03F);
		tr.setStartDate("2019/09/02");
		tr.setEndDate("2019/09/09");
		tr.setStartTime("09:00:00");
		tr.setEndTime("11:00:00");
		tr.setFees(2000F);
		tr.setStatus("normal");
		tr.setRazorpayPaymentId("123456");
		tr.setDesc("skill-MSQL-2-mentor-3");
		
		request.param("mentorId", "3");
		request.param("skillId", "2");
		request.param("progress", "20");
		request.param("amountReceive", "0.3");
		request.param("commissionAmount", "0.3");
		request.param("startDate", "2019/09/01");
		request.param("endDate", "2019/09/09");
		request.param("startTime", "09:00:00");
		request.param("endTime", "11:00:00");
		request.param("fees", "1000");
		request.param("status", "normal");
		request.param("razorpayPaymentId", "222222");
		request.param("desc", "MSQL-2-mentor-3");
	}

	public static void createTrainingSpring(MockHttpServletRequestBuilder request) {
		Training tr = new Training();
		tr.setMentorId(3L);
		tr.setSkillId(3L);
		tr.setProgress(100);
		tr.setAmountReceived(0.3F);
		tr.setCommissionAmount(03F);
		tr.setStartDate("2019/09/03");
		tr.setEndDate("2019/09/09");
		tr.setStartTime("09:00:00");
		tr.setEndTime("11:00:00");
		tr.setFees(3000F);
		tr.setStatus("normal");
		tr.setRazorpayPaymentId("123456");
		tr.setDesc("skill-Spring-3-mentor-3");
		
		request.param("mentorId", "3");
		request.param("skillId", "3");
		request.param("progress", "30");
		request.param("amountReceive", "0.3");
		request.param("commissionAmount", "0.3");
		request.param("startDate", "2019/09/01");
		request.param("endDate", "2019/09/09");
		request.param("startTime", "09:00:00");
		request.param("endTime", "11:00:00");
		request.param("fees", "1000");
		request.param("status", "normal");
		request.param("razorpayPaymentId", "1111111");
		request.param("desc", "Spring-3-mentor-3");
	}

	public static void createForUpdate(MockHttpServletRequestBuilder request) {
		Training tr = new Training();
		tr.setMentorId(3L);
		tr.setSkillId(3L);
		tr.setProgress(30);
		tr.setAmountReceived(0.3F);
		tr.setCommissionAmount(03F);
		tr.setStartDate("2019/09/03");
		tr.setEndDate("2019/09/09");
		tr.setStartTime("09:00:00");
		tr.setEndTime("11:00:00");
		tr.setFees(3000F);
		tr.setStatus("for update");
		tr.setRazorpayPaymentId("123456");
		tr.setDesc("skill-for test-3-mentor-3");
		
		request.param("mentorId", "3");
		request.param("skillId", "3");
		request.param("progress", "30");
		request.param("amountReceive", "0.3");
		request.param("commissionAmount", "0.3");
		request.param("startDate", "2019/09/01");
		request.param("endDate", "2019/09/09");
		request.param("startTime", "09:00:00");
		request.param("endTime", "11:00:00");
		request.param("fees", "1000");
		request.param("status", "normal");
		request.param("razorpayPaymentId", "1111111");
		request.param("desc", "for update-3-mentor-3");
	}

	public static void createForDelete(MockHttpServletRequestBuilder request) {
		Training tr = new Training();
		tr.setMentorId(3L);
		tr.setSkillId(3L);
		tr.setProgress(30);
		tr.setAmountReceived(0.3F);
		tr.setCommissionAmount(03F);
		tr.setStartDate("2019/09/03");
		tr.setEndDate("2019/09/09");
		tr.setStartTime("09:00:00");
		tr.setEndTime("11:00:00");
		tr.setFees(3000F);
		tr.setStatus("normal");
		tr.setRazorpayPaymentId("123456");
		tr.setDesc("for delete-3-mentor-3");
	}
}
