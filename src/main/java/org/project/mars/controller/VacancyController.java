package org.project.mars.controller;

import org.project.mars.dto.SkillInformation;
import org.project.mars.dto.VacancyDetails;
import org.project.mars.service.AccountService;
import org.project.mars.service.VacancyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.project.mars.controller.ExceptionHandlerController.ATTRIBUTE_ERROR;

@Controller
@RequestMapping("/vacancy")
public class VacancyController {
    public static final String ATTRIBUTE_VACANCY = "vacancy";
    public static final String PATH_CREATE_VACANCY_TEMPLATE = "vacancy/create";
    public static final String PATH_COMPANY_VACANCY_TEMPLATE = "vacancy/company-vacancy";
    private final VacancyService vacancyService;

    public VacancyController(VacancyService vacancyService) {
        this.vacancyService = vacancyService;
    }

    @GetMapping("/create")
    public String getCreateVacancyTemplate(@ModelAttribute(ATTRIBUTE_VACANCY) VacancyDetails vacancyDetails) {
        return PATH_CREATE_VACANCY_TEMPLATE;
    }

    @PostMapping("/create")
    public String createVacancy(@ModelAttribute(ATTRIBUTE_VACANCY) @Valid VacancyDetails vacancyDetails,
                                BindingResult bindingResult, Model model,
                                @RequestParam(required = false) boolean save,
                                @RequestParam(required = false) boolean addSkill,
                                @RequestParam(required = false) String indexSkill) {
        vacancyDetails.setCompanyName(AccountService.getEmployerFromSecurityContext().getCompany().getName());
        if (bindingResult.hasErrors()) {
            return PATH_CREATE_VACANCY_TEMPLATE;
        } else {
            if (save) {
                if (vacancyService.save(vacancyDetails)) {
                    return PATH_COMPANY_VACANCY_TEMPLATE;
                } else {
                    model.addAttribute(ATTRIBUTE_ERROR, "Already exists!");
                    return PATH_CREATE_VACANCY_TEMPLATE;
                }
            } else {
                if (addSkill) {
                    vacancyDetails.getSkillInformationList().add(new SkillInformation());
                }
                if (indexSkill != null) {
                    vacancyDetails.getSkillInformationList().remove(Integer.parseInt(indexSkill));
                }
                return PATH_CREATE_VACANCY_TEMPLATE;
            }
        }
    }

    @GetMapping("/company-vacancy")
    public String getCompanyVacancyTemplate() {
        return PATH_COMPANY_VACANCY_TEMPLATE;
    }
}
