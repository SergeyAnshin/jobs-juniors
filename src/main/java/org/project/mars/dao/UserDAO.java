package org.project.mars.dao;

import org.project.mars.entity.User;

import java.util.Optional;

public interface UserDAO extends BusinessEntityDAO<User> {

    Optional<User> findByIdJoinResume(long id);

    Optional<User> findByEmail(String email);
}
