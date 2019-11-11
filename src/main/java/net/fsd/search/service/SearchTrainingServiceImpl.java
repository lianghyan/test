package net.fsd.search.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.fsd.entity.Training;
import net.fsd.model.TrainingDtls;
import net.fsd.model.UserDtls;
import net.fsd.search.dao.SearchTrainingRepository;

@Service(value = "searchTrainingService")
public class SearchTrainingServiceImpl implements ISearchTrainingService {
	@Autowired
	SearchTrainingRepository trainingRepository;

	@Override
	public List<UserDtls> findTrainingBySkillId(long skillId) {
		List queryList = trainingRepository.findTrainingBySkillId(skillId);
		List ret = toTrainingDtlsList(queryList);
		return ret;
	}

	@Override
	public List<UserDtls> findTrainingByUserIdInProg(long userId) {
		List queryList = trainingRepository.findTrainingByUserIdInProg(userId);
		List ret = toTrainingDtlsList(queryList);
		return ret;
	}

	@Override
	public List<UserDtls> findTrainingByUserIdCompleted(long userId) {
		List queryList = trainingRepository.findTrainingByUserIdCompleted(userId);
		List ret = toTrainingDtlsList(queryList);
		return ret;
	}

	@Override
	public List<UserDtls> findTrainingByMentorIdInProg(long mentorId) {
		List queryList = trainingRepository.findTrainingByMentorIdInProg(mentorId);
		List ret = toTrainingDtlsList(queryList);
		return ret;
	}

	@Override
	public List<UserDtls> findTrainingByMentorIdCompleted(long mentorId) {
		List queryList = trainingRepository.findTrainingByMentorIdCompleted(mentorId);
		List ret = toTrainingDtlsList(queryList);
		return ret;
	}

	private List toTrainingDtlsList(List queryList) {
		
		List ret = new ArrayList();
		queryList.forEach(objs -> {
			Object[] arr = (Object[]) objs;
			TrainingDtls td = new TrainingDtls();
			// System.out.println(objs);
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
			ret.add(td);
		});
		return ret;
	}

	@Override
	public void addTraining(Training tr) {
		trainingRepository.save(tr);

	}

	@Override
	public void deleteTraining(long id) {
		trainingRepository.deleteById(id);

	}

	@Override
	public void loadTraining(long id) {
		trainingRepository.findById(id);

	}
}
