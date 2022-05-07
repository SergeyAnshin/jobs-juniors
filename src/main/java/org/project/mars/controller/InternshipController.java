package org.project.mars.controller;

import org.project.mars.dto.InternshipDetails;
import org.project.mars.entity.Employer;
import org.project.mars.service.InternshipService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

import static org.project.mars.controller.ExceptionHandlerController.ATTRIBUTE_ERROR;
import static org.project.mars.controller.ResumeController.REDIRECT_TO_HOME_PAGE;

@Controller
@RequestMapping("/internship")
public class InternshipController {
    public static final String ATTRIBUTE_INTERNSHIP = "internship";
    public static final String PATH_CREATE_INTERNSHIP_TEMPLATE = "internship/create";
    public static final String PATH_COMPANY_INTERNSHIP_TEMPLATE = "internship/company-internship";
    private final InternshipService internshipService;

    public InternshipController(InternshipService internshipService) {
        this.internshipService = internshipService;
    }

    @GetMapping("/create")
    public String getCreateInternshipTemplate(@ModelAttribute(ATTRIBUTE_INTERNSHIP) InternshipDetails internshipDetails) {
        return PATH_CREATE_INTERNSHIP_TEMPLATE;
    }

    @PostMapping("/create")
    public String createInternship(@ModelAttribute(ATTRIBUTE_INTERNSHIP) @Valid InternshipDetails internshipDetails,
                                   BindingResult bindingResult, Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Employer employer = (Employer) authentication.getPrincipal();
        internshipDetails.setCompanyName(employer.getCompany().getName());
        if (bindingResult.hasErrors()) {
            return PATH_CREATE_INTERNSHIP_TEMPLATE;
        } else {
            if (internshipService.save(internshipDetails)) {
                return REDIRECT_TO_HOME_PAGE;
            } else {
                model.addAttribute(ATTRIBUTE_ERROR, "Already exists!");
                return PATH_CREATE_INTERNSHIP_TEMPLATE;
            }
        }
    }

    @GetMapping("/company-internship")
    public String getCompanyInternshipTemplate() {
        return PATH_COMPANY_INTERNSHIP_TEMPLATE;
    }
}
