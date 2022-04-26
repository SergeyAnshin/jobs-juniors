package org.project.mars.service;

import org.project.mars.dao.UserDAO;
import org.project.mars.dto.RegisteringUser;
import org.project.mars.entity.User;
import org.project.mars.mapper.UserMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserService implements UserDetailsService {
    private final UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public boolean signup(RegisteringUser registeringUser) {
        User user = UserMapper.mapFromRegisteringUser(registeringUser);
        if (userDAO.exists(user)) {
            return false;
        } else {
            userDAO.save(user);
            return true;
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userDAO.findByUsername(username);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new UsernameNotFoundException("User with this username doesn't exist!");
        }
    }
}
