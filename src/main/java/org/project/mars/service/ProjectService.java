package org.project.mars.service;

import org.project.mars.dao.ProjectDAO;
import org.project.mars.dto.OpenSourceProject;
import org.project.mars.entity.Project;
import org.project.mars.mapper.ProjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class ProjectService {
    private final ProjectDAO projectDAO;

    public ProjectService(ProjectDAO projectDAO) {
        this.projectDAO = projectDAO;
    }

    public Set<OpenSourceProject> getOpenSourceProjects() {
        List<Project> projects = projectDAO.findAllByOpenSource();
        Set<OpenSourceProject> openSourceProjects = ProjectMapper.mapToOpenSourceProjectSet(projects);
        return openSourceProjects == null ? Collections.emptySet() : openSourceProjects;
    }
}
