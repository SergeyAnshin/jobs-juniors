package org.project.mars.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.project.mars.hibernatelistener.GeneralCreateUpdateListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({
        @NamedQuery(name = "Project.exists",
                query = "SELECT p FROM Project p WHERE p.link = :link"),
        @NamedQuery(name = "Project.findAllByOpenSource",
                query = "SELECT p FROM Project p WHERE p.openSource = true")
})

@Entity
@EntityListeners(GeneralCreateUpdateListener.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class Project extends BusinessEntity {
    private String name;
    private String description;
    private String tasks;
    private String stack;
    private String link;
    private boolean openSource;
}
