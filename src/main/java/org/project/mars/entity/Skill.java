package org.project.mars.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.project.mars.hibernatelistener.GeneralCreateUpdateListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NamedQueries({
        @NamedQuery(name = "Skill.exists",
                query = "SELECT s FROM Skill s WHERE s.name = :name"),
        @NamedQuery(name = "Skill.findAllByNameContainingIn",
                query = "SELECT s FROM Skill s LEFT JOIN FETCH s.resumes r WHERE s.name IN (:names)")
})

@Entity
@EntityListeners(GeneralCreateUpdateListener.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = false, exclude = "resumes")
@ToString(exclude = "resumes")
public class Skill extends BusinessEntity {
    private String name;
    @ManyToMany(mappedBy = "skills")
    private List<Resume> resumes = new ArrayList<>();
    @ManyToMany(mappedBy = "skills")
    private List<Vacancy> vacancies = new ArrayList<>();

    public void addResume(Resume resume) {
        resumes.add(resume);
    }

    public void removeSkill(Resume resume) {
        resumes.remove(resume);
    }
}
