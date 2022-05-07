package org.project.mars.mapper;

import org.project.mars.dto.RegisteringEmployer;
import org.project.mars.entity.Company;
import org.project.mars.entity.Employer;
import org.project.mars.entity.Role;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.stream.Collectors;

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

    public static UserDetails mapToUserDetails(Employer employer) {
        if (employer == null) {
            return null;
        } else {
            return Employer.builder()
                    .id(employer.getId())
                    .email(employer.getEmail())
                    .password(employer.getPassword())
                    .company(Company.builder()
                            .id(employer.getCompany().getId())
                            .name(employer.getCompany().getName())
                            .build())
                    .roles(employer.getRoles()
                            .stream()
                            .map(role -> Role.builder()
                                    .name(role.getName())
                                    .build())
                            .collect(Collectors.toSet()))
                    .build();
        }
    }
}
