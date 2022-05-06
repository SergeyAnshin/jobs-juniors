package org.project.mars.dao;

import org.project.mars.entity.Employer;

import java.util.Optional;

public interface EmployerDAO extends BusinessEntityDAO<Employer> {

    Optional<Employer> findByEmail(String email);
}
