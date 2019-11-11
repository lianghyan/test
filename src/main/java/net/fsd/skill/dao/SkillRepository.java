package net.fsd.skill.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.fsd.entity.Skill;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {

}
