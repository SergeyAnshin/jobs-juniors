package org.project.mars.dao;

import org.project.mars.entity.Project;

import java.util.List;

public interface ProjectDAO extends BusinessEntityDAO<Project> {

    List<Project> findAllByOpenSource();
}
