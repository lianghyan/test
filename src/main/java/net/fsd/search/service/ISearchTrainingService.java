package net.fsd.search.service;

import java.util.List;

import net.fsd.entity.Training;
import net.fsd.model.UserDtls;

public interface ISearchTrainingService {
	public List<UserDtls> findTrainingBySkillId(long skillId);

	public List<UserDtls> findTrainingByUserIdInProg(long userId);

	public List<UserDtls> findTrainingByUserIdCompleted(long userId);

	public List<UserDtls> findTrainingByMentorIdInProg(long mentorId);

	public List<UserDtls> findTrainingByMentorIdCompleted(long mentorId);

	public void addTraining(Training tr);

	public void deleteTraining(long trainingId);

	public void loadTraining(long trainingId);

}
