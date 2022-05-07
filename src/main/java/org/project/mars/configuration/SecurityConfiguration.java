package org.project.mars.configuration;

import org.project.mars.enums.RoleName;
import org.project.mars.service.AccountService;
import org.project.mars.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@PropertySource("classpath:securitypattern.properties")
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    private AccountService accountService;
    @Value("${permit.all}")
    private String[] permitAllPatterns;
    @Value("${permit.user}")
    private String[] permitUserPatterns;
    @Value("${permit.employer}")
    private String[] permitEmployerPatterns;

    public SecurityConfiguration(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                    .antMatchers(permitAllPatterns).permitAll()
                    .antMatchers(permitUserPatterns).hasAuthority(RoleName.USER.name())
                    .antMatchers(permitEmployerPatterns).hasAuthority(RoleName.EMPLOYER.name())
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .loginPage("/account/login")
                    .usernameParameter("email").passwordParameter("password")
                    .failureUrl("/account/login?failed=true")
                    .and()
                .logout()
                    .logoutUrl("/account/logout")
                    .logoutSuccessUrl("/account/login")
                    .invalidateHttpSession(true);
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(accountService).passwordEncoder(bCryptPasswordEncoder());
    }
}
