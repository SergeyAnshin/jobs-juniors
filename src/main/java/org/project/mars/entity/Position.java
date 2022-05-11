package org.project.mars.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.project.mars.hibernatelistener.GeneralCreateUpdateListener;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(name = "Position.exists",
                query = "SELECT p FROM Position p WHERE p.name = :name"),
        @NamedQuery(name = "Position.findAllByNameContainingIn",
                query = "SELECT p FROM Position p WHERE p.name IN (:names)")
})

@Entity
@Table(name = "position_table")
@EntityListeners(GeneralCreateUpdateListener.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class Position extends BusinessEntity {
    private String name;
}
