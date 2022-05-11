package org.project.mars.service;

import org.project.mars.dao.CompanyDAO;
import org.project.mars.dao.InternshipDAO;
import org.project.mars.dto.InternshipDetails;
import org.project.mars.entity.Company;
import org.project.mars.entity.Internship;
import org.project.mars.mapper.InternshipMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class InternshipService {
    private final InternshipDAO internshipDAO;
    private final CompanyDAO companyDAO;

    public InternshipService(InternshipDAO internshipDAO, CompanyDAO companyDAO) {
        this.internshipDAO = internshipDAO;
        this.companyDAO = companyDAO;
    }

    public boolean save(InternshipDetails internshipDetails) {
        Internship internship = InternshipMapper.mapFromInternshipDetails(internshipDetails);
        if (internshipDAO.exists(internship)) {
            return false;
        } else {
            Optional<Company> company = companyDAO.findByNameJoinInternship(internshipDetails.getCompanyName());
            if (company.isPresent()) {
                company.get().addInternship(internship);
                internship.setCompany(company.get());
            }
            internshipDAO.save(internship);
            return true;
        }
    }
}
