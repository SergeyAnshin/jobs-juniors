package org.project.mars.dao;

import org.project.mars.entity.Company;

import java.util.List;

public interface CompanyDAO extends BusinessEntityDAO<Company> {

    List<Company> findAllByNameContainingIn(List<String> companyNames);
}
