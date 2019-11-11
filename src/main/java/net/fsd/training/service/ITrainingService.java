package net.fsd.training.service;

import java.util.List;

import org.springframework.stereotype.Service;

import net.fsd.entity.Training;
import net.fsd.model.TrainingDtls;
import net.fsd.model.UserDtls;

public interface ITrainingService {

	List<TrainingDtls> listTraining();

	void deleteTraining(long id);

	void updateTraining(Training tr);

	Training addTraining(Training tr);
	
	public TrainingDtls findById(long id);

}
