package org.project.mars.controller;

import org.project.mars.service.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/project")
public class ProjectController {
    public static final String ATTRIBUTE_OPEN_SOURCE_PROJECTS = "openSourceProjects";
    public static final String PATH_OPEN_SOURCE_PROJECT_TEMPLATE = "project/open-source-projects";
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/open-source")
    public String getOpenSourceProjectTemplate(Model model) {
        model.addAttribute(ATTRIBUTE_OPEN_SOURCE_PROJECTS, projectService.getOpenSourceProjects());
        return PATH_OPEN_SOURCE_PROJECT_TEMPLATE;
    }
}
