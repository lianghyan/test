package net.fsd.skill.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.fsd.comm.BaseController;
import net.fsd.entity.Skill;
import net.fsd.skill.service.ISkillService;

@RestController
@RequestMapping("/skill")
public class SkillController extends BaseController {
	@Autowired
	ISkillService skillService;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Map addSkill(Skill u) {
		Skill s = skillService.addSkill(u);
		Map map = composeReturnMap();
		map.put("id", s.getId());
		return map;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public Map updateSkill(Skill u) {
		skillService.updateSkill(u);
		return composeReturnMap();
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public Map deleteSkill(long skillId) {
		skillService.deleteSkill(skillId);
		return composeReturnMap();
	}

	@RequestMapping(value = "/find", method = RequestMethod.POST)
	@ResponseBody
	public Skill findSkill(long skillId) {
		return skillService.findSkillById(skillId);
	}

	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public List<Skill> listSkill() {
		return skillService.listSkill();
	}
}
