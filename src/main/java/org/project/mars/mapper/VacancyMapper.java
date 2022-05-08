package org.project.mars.mapper;

import org.project.mars.dto.VacancyDetails;
import org.project.mars.entity.Company;
import org.project.mars.entity.Skill;
import org.project.mars.entity.User;
import org.project.mars.entity.Vacancy;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.HashSet;
import java.util.Set;

public class VacancyMapper {

    public static Vacancy mapFromVacancyDetails(VacancyDetails vacancyDetails) {
        if (vacancyDetails == null) {
            return null;
        } else {
            return Vacancy.builder()
                    .name(vacancyDetails.getName())
                    .salary(vacancyDetails.getSalary())
                    .requiredExperience(vacancyDetails.getRequiredExperience())
                    .aboutCompany(vacancyDetails.getAboutCompany())
                    .aboutCustomer(vacancyDetails.getAboutCustomer())
                    .aboutProject(vacancyDetails.getAboutProject())
                    .requirements(vacancyDetails.getRequirements())
                    .niceToHave(vacancyDetails.getNiceToHave())
                    .responsibilities(vacancyDetails.getResponsibilities())
                    .companyAdvantages(vacancyDetails.getCompanyAdvantages())
                    .additionalInformation(vacancyDetails.getAdditionalInformation())
                    .skills(SkillMapper.mapFromSkillInformationList(vacancyDetails.getSkillInformationList()))
                    .company(Company.builder()
                            .name(vacancyDetails.getName())
                            .build())
                    .build();
        }
    }
}
