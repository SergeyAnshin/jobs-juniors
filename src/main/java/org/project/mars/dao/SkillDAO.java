package org.project.mars.dao;

import org.project.mars.entity.Skill;

import java.util.List;

public interface SkillDAO extends BusinessEntityDAO<Skill> {

    List<Skill> findAllByNameContainingIn(List<String> skillNames);
}
