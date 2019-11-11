package net.fsd.training.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.fsd.comm.BaseController;
import net.fsd.entity.Training;
import net.fsd.model.TrainingDtls;
import net.fsd.training.service.ITrainingService;

@RestController
@RequestMapping("/training")
public class TrainingController extends BaseController {
	@Autowired
	ITrainingService trainingSevice;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Map addTraining(Training tr) {
		Training t = trainingSevice.addTraining(tr);
		Map map = composeReturnMap();
		map.put("id", t.getId());
		return map;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Map updateTraining(Training tr) {
		trainingSevice.updateTraining(tr);
		return composeReturnMap();
	}

	@RequestMapping(value = "/find", method = RequestMethod.POST)
	public TrainingDtls findById(long trainingId) {
		TrainingDtls tr = trainingSevice.findById(trainingId);
		return tr;
	}

	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public List<TrainingDtls> listTraining() {

		return trainingSevice.listTraining();
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public Map deleteTraining(@RequestParam("trainingId") long id) {
		trainingSevice.deleteTraining(id);
		return composeReturnMap();
	}

}
