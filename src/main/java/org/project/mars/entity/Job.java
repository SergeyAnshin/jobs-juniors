package org.project.mars.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.project.mars.hibernatelistener.GeneralCreateUpdateListener;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@EntityListeners(GeneralCreateUpdateListener.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class Job extends BusinessEntity {
    @ManyToOne
    private Company company;
    @ManyToOne
    private Position position;
    private LocalDate employmentDate;
    private LocalDate dismissalDate;
    private String jobResponsibilities;
    private String jobAchievements;
}
