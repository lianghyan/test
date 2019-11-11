package net.fsd.search.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.fsd.comm.BaseController;
import net.fsd.entity.Training;
import net.fsd.entity.UserTraining;
import net.fsd.model.TrainingDtls;
import net.fsd.search.service.IUserTrainingService;

@RestController
@RequestMapping("/usertraining")
public class UserTrainingController extends BaseController {
	@Autowired
	IUserTrainingService userTrainingService;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Map addTraining(UserTraining tr) {
		UserTraining t = userTrainingService.addTraining(tr);
		Map map = composeReturnMap();
		map.put("id", t.getId());
		return map;
	}

	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public List<TrainingDtls> listTraining(long userId) {
		return userTrainingService.listUserTraining(userId);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public Map deleteTraining(@RequestParam("id") long id) {
		userTrainingService.deleteTraining(id);
		return composeReturnMap();
	}
}
