package org.project.mars.service;

import org.project.mars.dao.CompanyDAO;
import org.project.mars.dao.EmployerDAO;
import org.project.mars.dao.RoleDAO;
import org.project.mars.dao.UserDAO;
import org.project.mars.dto.RegisteringEmployer;
import org.project.mars.dto.RegisteringUser;
import org.project.mars.entity.Company;
import org.project.mars.entity.Employer;
import org.project.mars.entity.Role;
import org.project.mars.entity.User;
import org.project.mars.enums.RoleName;
import org.project.mars.mapper.EmployerMapper;
import org.project.mars.mapper.UserMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class AccountService implements UserDetailsService {
    private final UserDAO userDAO;
    private final RoleDAO roleDAO;
    private final EmployerDAO employerDAO;
    private final CompanyDAO companyDAO;

    public AccountService(UserDAO userDAO, RoleDAO roleDAO, EmployerDAO employerDAO, CompanyDAO companyDAO) {
        this.userDAO = userDAO;
        this.roleDAO = roleDAO;
        this.employerDAO = employerDAO;
        this.companyDAO = companyDAO;
    }

    public boolean signupUser(RegisteringUser registeringUser) {
        User user = UserMapper.mapFromRegisteringUser(registeringUser);
        if (userDAO.exists(user)) {
            return false;
        } else {
            Optional<Role> roleUser = roleDAO.findByNameJoinUser(RoleName.USER.name());
            user.addRole(roleUser.get());
            userDAO.save(user);
            return true;
        }
    }

    public boolean signupEmployer(RegisteringEmployer registeringEmployer) {
        Employer employer = EmployerMapper.mapFromRegisteringEmployer(registeringEmployer);
        if (employerDAO.exists(employer)) {
            return false;
        } else {
            Optional<Role> roleEmployer = roleDAO.findByNameJoinEmployer(RoleName.EMPLOYER.name());
            Optional<Company> company = companyDAO.findByNameJoinEmployer(registeringEmployer.getCompanyName());
            employer.addRole(roleEmployer.get());
            if (company.isPresent()) {
                employer.setCompany(company.get());
                company.get().addEmployer(employer);
            }
            employerDAO.save(employer);
            return true;
        }
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = userDAO.findByEmail(email);
        if (user.isPresent()) {
            return user.get();
        } else {
            Optional<Employer> employer = employerDAO.findByEmail(email);
            if (employer.isPresent()) {
                return EmployerMapper.mapToUserDetails(employer.get());
            } else {
                throw new UsernameNotFoundException("User with this username doesn't exist!");
            }
        }
    }

    public static Employer getEmployerFromSecurityContext() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (Employer) authentication.getPrincipal();
    }

    public static User getUserFromSecurityContext() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (User) authentication.getPrincipal();
    }
}
