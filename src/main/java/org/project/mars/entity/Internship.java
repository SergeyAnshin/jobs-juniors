package org.project.mars.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.project.mars.hibernatelistener.GeneralCreateUpdateListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import java.time.LocalDate;

@Entity
@EntityListeners(GeneralCreateUpdateListener.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class Internship extends BusinessEntity {
    private String name;
    private String technology;
    private LocalDate startDate;
    private LocalDate finishDate;
    private String description;
    private String stack;
    private String requirements;
    private String contact;
}
