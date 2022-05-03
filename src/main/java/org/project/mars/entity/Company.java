package org.project.mars.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.project.mars.hibernatelistener.GeneralCreateUpdateListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NamedQueries({
        @NamedQuery(name = "Company.exists",
                query = "SELECT c FROM Company c WHERE c.name = :name"),
        @NamedQuery(name = "Company.findAllByNameContainingIn",
                query = "SELECT c FROM Company c LEFT JOIN FETCH c.jobs WHERE c.name IN (:names)")
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


    public void addJob(Job job) {
        jobs.add(job);
        job.setCompany(this);
    }

    public void removeJob(Job job) {
        jobs.remove(job);
        job.setCompany(null);
    }
}
