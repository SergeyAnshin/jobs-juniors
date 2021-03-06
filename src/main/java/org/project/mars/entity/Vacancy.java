package org.project.mars.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.project.mars.hibernatelistener.GeneralCreateUpdateListener;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@NamedQueries({
        @NamedQuery(name = "Vacancy.exists",
                query = "SELECT v FROM Vacancy v WHERE v.name = :name AND v.salary = :salary " +
                        "AND v.requiredExperience = :requiredExperience AND v.aboutProject = :aboutProject " +
                        "AND v.requirements = :requirements AND v.responsibilities = :responsibilities " +
                        "AND v.company.name = :companyName")
})

@Entity
@EntityListeners(GeneralCreateUpdateListener.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class Vacancy extends BusinessEntity {
    private String name;
    private String salary;
    private String requiredExperience;
    private String aboutCompany;
    private String aboutCustomer;
    private String aboutProject;
    private String requirements;
    private String niceToHave;
    private String responsibilities;
    private String companyAdvantages;
    private String additionalInformation;
    @ManyToMany
    @JoinTable(name="vacancies_skills", joinColumns = @JoinColumn(name = "vacancy_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id"))
    private Set<Skill> skills = new HashSet<>();
    @ManyToOne
    private Company company;
}
