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
public class Education extends BusinessEntity {
    private String educationalInstitution;
    private String faculty;
    private String specialization;
    private LocalDate enrollmentDate;
    private LocalDate graduationDate;
}
