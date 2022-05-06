package org.project.mars.service;

import org.project.mars.dao.UserDAO;
import org.project.mars.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserService {
    private final UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public Optional<User> findByIdWithResumes(long id) {
        return userDAO.findByIdJoinResume(id);
    }
}
