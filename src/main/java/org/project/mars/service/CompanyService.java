package org.project.mars.service;

import org.project.mars.dao.CompanyDAO;
import org.project.mars.entity.Company;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CompanyService {
    private final CompanyDAO companyDAO;

    public CompanyService(CompanyDAO companyDAO) {
        this.companyDAO = companyDAO;
    }

    public List<Company> findAllByNameContainingIn(List<Company> companies) {
        List<String> companyNames = companies.stream()
                .map(Company::getName)
                .collect(Collectors.toList());
        return companyDAO.findAllByNameContainingIn(companyNames);
    }
}
