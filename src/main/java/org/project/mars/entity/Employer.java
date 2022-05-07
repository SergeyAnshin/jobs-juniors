package org.project.mars.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.project.mars.hibernatelistener.GeneralCreateUpdateListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@NamedQueries({
        @NamedQuery(name = "Employer.exists",
                query = "SELECT e FROM Employer e WHERE e.email = :email"),
        @NamedQuery(name = "Employer.findByEmail",
                query = "SELECT e FROM Employer e JOIN FETCH e.roles JOIN FETCH e.company WHERE e.email = :email")
})

@Entity
@EntityListeners(GeneralCreateUpdateListener.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class Employer extends BusinessEntity implements UserDetails {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String password;
    @ManyToOne
    private Company company;
    @ManyToMany(cascade = {CascadeType.MERGE})
    @JoinTable(name="employers_roles", joinColumns = @JoinColumn(name = "employer_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getAuthority()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void addRole(Role role) {
        roles.add(role);
        role.getEmployers().add(this);
    }

    public void removeRole(Role role) {
        roles.remove(role);
        role.getEmployers().remove(this);
    }
}
