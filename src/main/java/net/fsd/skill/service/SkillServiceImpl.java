package net.fsd.skill.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.fsd.entity.Skill;
import net.fsd.skill.dao.SkillRepository;

@Service(value = "skillService")
public class SkillServiceImpl implements ISkillService {
	@Autowired
	SkillRepository skillDAO;

	@Override
	public Skill addSkill(Skill s) {
		skillDAO.saveAndFlush(s);
		return s;
	}

	@Override
	public Skill updateSkill(Skill s) {
		skillDAO.saveAndFlush(s);
		return s;
	}

	@Override
	public Skill findSkillById(long id) {
		return skillDAO.findById(id).get();
	}

	@Override
	public void deleteSkill(long skillId) {
		skillDAO.deleteById(skillId);
	}

	@Override
	public List listSkill() {
		return skillDAO.findAll();
	}
}
