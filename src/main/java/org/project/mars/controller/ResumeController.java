package org.project.mars.controller;

import org.project.mars.dto.*;
import org.project.mars.entity.User;
import org.project.mars.service.AccountService;
import org.project.mars.service.GeneralInformationService;
import org.project.mars.service.ResumeService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

import static org.project.mars.controller.ExceptionHandlerController.ATTRIBUTE_ERROR;

@Controller
@RequestMapping("/resume")
public class ResumeController {
    public static final String ATTRIBUTE_RESUME = "resume";
    public static final String ATTRIBUTE_RESUMES = "resumes";
    public static final String ATTRIBUTE_GENERAL_INFORMATION_DETAILS = "generalInformationDetails";
    public static final String ATTRIBUTE_SUCCESSFUL_UPDATE = "successfulUpdate";
    public static final String PATH_CREATE_RESUME_TEMPLATE = "resume/create";
    public static final String PATH_RESUME_EDIT_MENU_TEMPLATE = "resume/edit-menu";
    public static final String PATH_EDIT_GENERAL_INFORMATION_TEMPLATE = "resume/edit-general-information";
    public static final String PATH_MY_RESUME_TEMPLATE = "resume/my-resume";
    public static final String REDIRECT_TO_HOME_PAGE = "redirect:/";
    public static final String REDIRECT_TO_RESUME_PAGE = "redirect:/resume";
    private final ResumeService resumeService;
    private final GeneralInformationService generalInformationService;

    public ResumeController(ResumeService resumeService, GeneralInformationService generalInformationService) {
        this.resumeService = resumeService;
        this.generalInformationService = generalInformationService;
    }

    @GetMapping
    public String getMyResumeTemplate(Model model) {
        User user = AccountService.getUserFromSecurityContext();
        model.addAttribute(ATTRIBUTE_RESUMES, resumeService.findAllByUser(user));
        return PATH_MY_RESUME_TEMPLATE;
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
        if (!bindingResult.hasErrors()) {
            if (save) {
                User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                resumeDTO.setOwnerId(user.getId());
                System.out.println(user.getId());
                resumeService.save(resumeDTO);
                return REDIRECT_TO_RESUME_PAGE;
            }
        }
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

    @PostMapping("/delete")
    public String deleteResume(@RequestParam long resumeId) {
        resumeService.deleteById(resumeId);
        return REDIRECT_TO_RESUME_PAGE;
    }

    @GetMapping("/edit-menu")
    public String getResumeEditMenuTemplate() {
        return PATH_RESUME_EDIT_MENU_TEMPLATE;
    }

    @GetMapping("/edit/general-information")
    public String getEditGeneralInformationTemplate(Model model, @RequestParam long id) {
        Optional<GeneralInformationDetails> generalInfoDetails = generalInformationService.getGeneralInformationDetailsByResumeId(id);
        generalInfoDetails.ifPresent(generalInformationDetails -> model.addAttribute(ATTRIBUTE_GENERAL_INFORMATION_DETAILS, generalInformationDetails));
        return PATH_EDIT_GENERAL_INFORMATION_TEMPLATE;
    }

    @PostMapping("/edit/general-information")
    public String editGeneralInformation(@ModelAttribute(ATTRIBUTE_GENERAL_INFORMATION_DETAILS) @Valid GeneralInformationDetails generalInformationDetails,
                                         BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return PATH_EDIT_GENERAL_INFORMATION_TEMPLATE;
        } else {
            if (generalInformationService.update(generalInformationDetails)) {
                model.addAttribute(ATTRIBUTE_SUCCESSFUL_UPDATE, "General information updated!");
                return PATH_EDIT_GENERAL_INFORMATION_TEMPLATE;
            } else {
                model.addAttribute(ATTRIBUTE_ERROR, "Failed to update!");
                return PATH_EDIT_GENERAL_INFORMATION_TEMPLATE;
            }
        }
    }
}
