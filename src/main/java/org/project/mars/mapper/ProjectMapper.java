package org.project.mars.mapper;

import org.project.mars.dto.OpenSourceProject;
import org.project.mars.dto.ProjectInformation;
import org.project.mars.entity.Project;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ProjectMapper {

    public static Project mapFromProjectInformation(ProjectInformation projectInformation) {
        if (projectInformation == null) {
            return null;
        } else {
            return Project.builder()
                    .name(projectInformation.getName())
                    .description(projectInformation.getDescription())
                    .tasks(projectInformation.getTasks())
                    .stack(projectInformation.getStack())
                    .link(projectInformation.getLink())
                    .openSource(projectInformation.isOpenSource())
                    .build();
        }
    }

    public static Set<Project> mapFromProjectInformationSet(List<ProjectInformation> projectInformationList) {
        if (projectInformationList == null || projectInformationList.isEmpty()) {
            return null;
        } else {
            return projectInformationList.stream()
                    .map(ProjectMapper::mapFromProjectInformation)
                    .collect(Collectors.toSet());
        }
    }

    public static OpenSourceProject mapToOpenSourceProject(Project project) {
        if (project == null) {
            return null;
        } else {
            return OpenSourceProject.builder()
                    .name(project.getName())
                    .description(project.getDescription())
                    .stack(project.getStack())
                    .link(project.getLink())
                    .build();
        }
    }

    public static Set<OpenSourceProject> mapToOpenSourceProjectSet(List<Project> projects) {
        if (projects == null || projects.isEmpty()) {
            return null;
        } else {
            return projects.stream()
                    .map(ProjectMapper::mapToOpenSourceProject)
                    .collect(Collectors.toSet());
        }
    }
}
