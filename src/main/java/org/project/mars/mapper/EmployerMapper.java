package org.project.mars.mapper;

import org.project.mars.dto.RegisteringEmployer;
import org.project.mars.entity.Company;
import org.project.mars.entity.Employer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;

public class EmployerMapper {
    private static final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public static Employer mapFromRegisteringEmployer(RegisteringEmployer registeringEmployer) {
        if (registeringEmployer == null) {
            return null;
        } else {
            return Employer.builder()
                    .firstName(registeringEmployer.getFirstName())
                    .lastName(registeringEmployer.getLastName())
                    .phoneNumber(registeringEmployer.getPhoneNumber())
                    .email(registeringEmployer.getEmail())
                    .company(Company.builder().name(registeringEmployer.getCompanyName()).build())
                    .roles(new HashSet<>())
                    .build();
        }
    }
}
