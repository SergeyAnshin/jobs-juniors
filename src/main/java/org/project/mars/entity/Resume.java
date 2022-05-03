package org.project.mars.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.project.mars.hibernatelistener.GeneralCreateUpdateListener;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@EntityListeners(GeneralCreateUpdateListener.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class Resume extends BusinessEntity {
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "general_information_id")
    private GeneralInformation generalInformation;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name="resume_id", nullable = false)
    private Set<Job> workExperience = new HashSet<>();
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "resume_id", nullable = false)
    private Set<Project> projects = new HashSet<>();
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "resume_id", nullable = false)
    private Set<Education> education = new HashSet<>();
    @OneToMany(cascade = CascadeType.PERSIST )
    @JoinColumn(name = "resume_id", nullable = false)
    private Set<Course> courses = new HashSet<>();
    @ManyToMany
    @JoinTable(name="resumes_skills", joinColumns = @JoinColumn(name = "resume_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id"))
    private Set<Skill> skills = new HashSet<>();


    public void addSkill(Skill skill) {
        skills.add(skill);
        skill.getResumes().add(this);
    }

    public void removeSkill(Skill skill) {
        skills.remove(skill);
        skill.getResumes().remove(this);
    }
}
