package org.project.mars.service;

import org.project.mars.dao.ProjectDAO;
import org.project.mars.dto.OpenSourceProject;
import org.project.mars.entity.Project;
import org.project.mars.mapper.ProjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProjectService {
    private final ProjectDAO projectDAO;

    public ProjectService(ProjectDAO projectDAO) {
        this.projectDAO = projectDAO;
    }

    public Set<OpenSourceProject> getOpenSourceProjects() {
        List<Project> projects = projectDAO.findAllByOpenSource();
        Map<String, Project> uniqueProjects = projects.stream()
                .collect(Collectors.toMap(Project::getLink, Function.identity(), (existingProject, newProject) -> existingProject));
        Set<OpenSourceProject> openSourceProjects = ProjectMapper.mapToOpenSourceProjectSet(new ArrayList<>(uniqueProjects.values()));
        return openSourceProjects == null ? Collections.emptySet() : openSourceProjects;
    }
}
