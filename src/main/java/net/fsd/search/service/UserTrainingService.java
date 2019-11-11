package net.fsd.search.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.fsd.entity.Training;
import net.fsd.entity.UserTraining;
import net.fsd.search.dao.UserTrainingRepository;

@Service(value = "userTrainingService")
public class UserTrainingService  implements IUserTrainingService{
	@Autowired
	UserTrainingRepository userTrainingRepository;

	@Override
	public List listUserTraining(long userId) {
		return userTrainingRepository.listUserTraining(userId);
	}

	@Override
	public UserTraining addTraining(UserTraining tr) {
		return userTrainingRepository.saveAndFlush(tr);
	}

	@Override
	public void deleteTraining(long id) {
		userTrainingRepository.deleteById(id);
	}
	
	@Override
	public UserTraining findById(long id) {
		UserTraining tr = userTrainingRepository.findById(id).get();		 
		return tr;
	}
}
