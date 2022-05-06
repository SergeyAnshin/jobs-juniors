package org.project.mars.dao;

import org.project.mars.entity.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyDAO extends BusinessEntityDAO<Company> {

    List<Company> findAllByNameContainingIn(List<String> companyNames);

    Optional<Company> findByNameJoinEmployer(String name);
}
