package net.fsd.search.service;

import java.util.List;

import net.fsd.entity.Training;
import net.fsd.entity.UserTraining;

public interface IUserTrainingService {

	List listUserTraining(long userId);

	UserTraining addTraining(UserTraining tr);

	void deleteTraining(long id);

	UserTraining findById(long id);

}
