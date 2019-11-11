package net.fsd.search.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.fsd.comm.BaseController;
import net.fsd.search.service.ISearchTrainingService;

@RestController
@RequestMapping("/search")
public class SearchController  extends BaseController {
	@Autowired
	ISearchTrainingService searchTrainingService;

	// http://localhost:8080/fsdmvc/app/training/skill/1
	@RequestMapping(value = "/skill", method = RequestMethod.POST)
	public List findTrainingBySkillId(@RequestParam("id") long skillId) {
		List list = searchTrainingService.findTrainingBySkillId(skillId);
		return list;
	}

	// http://localhost:8080/fsdmvc/app/training/userprog/1
	@RequestMapping(value = "/userprog", method = RequestMethod.POST)
 	public List findTrainingByUserIdInProg(@RequestParam("id") long userId) {
		List list = searchTrainingService.findTrainingByUserIdInProg(userId);
		return list;
	}

	// http://localhost:8080/fsdmvc/app/training/usercomp/1
	@RequestMapping(value = "/usercomp", method = RequestMethod.POST)
 	public List findTrainingByUserIdCompleted(@RequestParam("id")  long userId) {
		List list = searchTrainingService.findTrainingByUserIdCompleted(userId);
		return list;
	}

	// http://localhost:8080/fsdmvc/app/training/mentorprog/1
	@RequestMapping(value = "/mentorprog", method = RequestMethod.POST)
 	public List findTrainingByMentorIdInProg(@RequestParam("id")  long mentorId) {
		List list = searchTrainingService.findTrainingByMentorIdInProg(mentorId);
		return list;
	}

	// http://localhost:8080/fsdmvc/app/training/mentorcomp/1
	@RequestMapping(value = "/mentorcomp", method = RequestMethod.POST)
 	public List findTrainingByMentorIdCompleted(@RequestParam("id")  long mentorId) {
		List list = searchTrainingService.findTrainingByMentorIdCompleted(mentorId);
		return list;
	}
}
