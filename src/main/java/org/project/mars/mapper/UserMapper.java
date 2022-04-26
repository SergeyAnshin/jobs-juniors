package org.project.mars.mapper;

import org.project.mars.dto.RegisteringUser;
import org.project.mars.entity.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;

public class UserMapper {
    private static final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public static User mapFromRegisteringUser(RegisteringUser registeringUser) {
        if (registeringUser == null) {
            return null;
        } else {
            return User.builder()
                    .firstName(registeringUser.getFirstName())
                    .lastName(registeringUser.getLastName())
                    .username(registeringUser.getUsername())
                    .email(registeringUser.getEmail())
                    .roles(new HashSet<>())
                    .password(bCryptPasswordEncoder.encode(registeringUser.getPassword()))
                    .build();
        }
    }
}
