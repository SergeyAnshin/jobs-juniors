package org.project.mars.service;

import org.project.mars.dao.CompanyDAO;
import org.project.mars.dao.VacancyDAO;
import org.project.mars.dto.VacancyDetails;
import org.project.mars.entity.Company;
import org.project.mars.entity.Vacancy;
import org.project.mars.mapper.VacancyMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class VacancyService {
    private final VacancyDAO vacancyDAO;
    private final CompanyDAO companyDAO;
    private final SkillService skillService;

    public VacancyService(VacancyDAO vacancyDAO, CompanyDAO companyDAO, SkillService skillService) {
        this.vacancyDAO = vacancyDAO;
        this.companyDAO = companyDAO;
        this.skillService = skillService;
    }

    public boolean save(VacancyDetails vacancyDetails) {
        Vacancy vacancy = VacancyMapper.mapFromVacancyDetails(vacancyDetails);
        if (vacancyDAO.exists(vacancy)) {
            return false;
        } else {
            Optional<Company> company = companyDAO.findByNameJoinVacancy(vacancy.getCompany().getName());
            company.ifPresent(value -> value.addVacancy(vacancy));
            if (vacancy.getSkills() != null) {
                skillService.replaceSkillsWithPersistentIfExists(vacancy.getSkills());
            }
            vacancyDAO.save(vacancy);
            return true;
        }
    }
}
