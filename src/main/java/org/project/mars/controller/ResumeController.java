package org.project.mars.controller;

import org.project.mars.dto.*;
import org.project.mars.service.ResumeService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/resume")
public class ResumeController {
    public static final String ATTRIBUTE_RESUME = "resume";
    public static final String PATH_CREATE_RESUME_TEMPLATE = "resume/create";
    public static final String REDIRECT_TO_HOME_PAGE = "redirect:/";
    private final ResumeService resumeService;

    public ResumeController(ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    @GetMapping("/create")
    public String getCreateResumeTemplate(@ModelAttribute(ATTRIBUTE_RESUME) ResumeDTO resumeDTO) {
        return PATH_CREATE_RESUME_TEMPLATE;
    }

    @PostMapping("/create")
    public String createResume(@ModelAttribute(ATTRIBUTE_RESUME) @Valid ResumeDTO resumeDTO,
                                         BindingResult bindingResult,
                                         @RequestParam(required = false) boolean save,
                                         @RequestParam(required = false) boolean addJobInformation,
                                         @RequestParam(required = false) String indexJobInformation,
                                         @RequestParam(required = false) boolean addProject,
                                         @RequestParam(required = false) String indexProject,
                                         @RequestParam(required = false) boolean addEducation,
                                         @RequestParam(required = false) String indexEducation,
                                         @RequestParam(required = false) boolean addCourse,
                                         @RequestParam(required = false) String indexCourse,
                                         @RequestParam(required = false) boolean addSkill,
                                         @RequestParam(required = false) String indexSkill) {
        if (bindingResult.hasErrors()) {
            return PATH_CREATE_RESUME_TEMPLATE;
        } else {
            if (save) {
                resumeService.save(resumeDTO);
                return REDIRECT_TO_HOME_PAGE;
            } else {
                if (addJobInformation) {
                    resumeDTO.getJobs().add(new JobInformation());
                }
                if (indexJobInformation != null) {
                    resumeDTO.getJobs().remove(Integer.parseInt(indexJobInformation));
                }
                if (addProject) {
                    resumeDTO.getProjectInformationList().add(new ProjectInformation());
                }
                if (indexProject != null) {
                    resumeDTO.getProjectInformationList().remove(Integer.parseInt(indexProject));
                }
                if (addEducation) {
                    resumeDTO.getEducationInformationList().add(new EducationInformation());
                }
                if (indexEducation != null) {
                    resumeDTO.getEducationInformationList().remove(Integer.parseInt(indexEducation));
                }
                if (addCourse) {
                    resumeDTO.getCourseInformationList().add(new CourseInformation());
                }
                if (indexCourse != null) {
                    resumeDTO.getCourseInformationList().remove(Integer.parseInt(indexCourse));
                }
                if (addSkill) {
                    resumeDTO.getSkillInformationList().add(new SkillInformation());
                }
                if (indexSkill != null) {
                    resumeDTO.getSkillInformationList().remove(Integer.parseInt(indexSkill));
                }
                return PATH_CREATE_RESUME_TEMPLATE;
            }
        }
    }
}
