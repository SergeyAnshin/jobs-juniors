package org.project.mars.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.project.mars.hibernatelistener.GeneralCreateUpdateListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NamedQueries({
        @NamedQuery(name = "Company.exists",
                query = "SELECT c FROM Company c WHERE c.name = :name"),
        @NamedQuery(name = "Company.findAllByNameContainingIn",
                query = "SELECT c FROM Company c LEFT JOIN FETCH c.jobs WHERE c.name IN (:names)"),
        @NamedQuery(name = "Company.findByNameJoinEmployer",
                query = "SELECT c FROM Company c LEFT JOIN FETCH c.employers WHERE c.name = :name"),
        @NamedQuery(name = "Company.findByNameJoinInternship",
                query = "SELECT c FROM Company c LEFT JOIN FETCH c.internships WHERE c.name = :name")
})

@Entity
@EntityListeners(GeneralCreateUpdateListener.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = false, of = {"name"})
@ToString(exclude = "jobs")
public class Company extends BusinessEntity {
    private String name;
    private String site;
    @OneToMany(mappedBy = "company")
    private List<Job> jobs = new ArrayList<>();
    @OneToMany(mappedBy = "company")
    private Set<Employer> employers = new HashSet<>();
    @OneToMany(mappedBy = "company")
    private Set<Internship> internships = new HashSet<>();

    public void addJob(Job job) {
        jobs.add(job);
        job.setCompany(this);
    }

    public void removeJob(Job job) {
        jobs.remove(job);
        job.setCompany(null);
    }

    public void addEmployer(Employer employer) {
        employers.add(employer);
        employer.setCompany(this);
    }

    public void removeEmployer(Employer employer) {
        employers.remove(employer);
        employer.setCompany(null);
    }

    public void addInternship(Internship internship) {
        internships.add(internship);
        internship.setCompany(this);
    }

    public void removeInternship(Internship internship) {
        internships.remove(internship);
        internship.setCompany(null);
    }
}
