package net.fsd.skill.service;

import java.util.List;

import net.fsd.entity.Skill;

public interface ISkillService {

	Skill addSkill(Skill s);

	Skill updateSkill(Skill s);

	Skill findSkillById(long id);

	void deleteSkill(long skillId);

	List listSkill();

}