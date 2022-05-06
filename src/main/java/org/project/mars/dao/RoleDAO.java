package org.project.mars.dao;

import org.project.mars.entity.Role;

import java.util.Optional;

public interface RoleDAO extends BusinessEntityDAO<Role> {

    Optional<Role> findByNameJoinUser(String name);

    Optional<Role> findByNameJoinEmployer(String name);
}
