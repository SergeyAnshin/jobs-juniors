package org.project.mars.service;

import org.project.mars.entity.Company;
import org.project.mars.entity.Job;
import org.project.mars.entity.Position;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class JobService {
    private CompanyService companyService;
    private PositionService positionService;

    public JobService(CompanyService companyService, PositionService positionService) {
        this.companyService = companyService;
        this.positionService = positionService;
    }

    void replaceCompaniesWithPersistentIfExists(Set<Job> workExperience) {
        List<Company> existingCompanies = companyService.findAllByNameContainingIn(workExperience.stream()
                .map(Job::getCompany)
                .collect(Collectors.toList()));
        workExperience.forEach(job -> {
            int existingCompanyIndex;
            if ((existingCompanyIndex = existingCompanies.indexOf(job.getCompany())) >= 0) {
                job.setCompany(existingCompanies.get(existingCompanyIndex));
            }
        });
    }

    void replacePositionsWithPersistentIfExists(Set<Job> workExperience) {
        List<Position> existingPositions = positionService.findAllByNameContainingIn(workExperience.stream()
                .map(Job::getPosition)
                .collect(Collectors.toList()));
        workExperience.forEach(job -> {
            int existingPositionIndex;
            if ((existingPositionIndex = existingPositions.indexOf(job.getPosition())) >= 0) {
                job.setPosition(existingPositions.get(existingPositionIndex));
            }
        });
    }
}
