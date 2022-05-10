package org.project.mars.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.project.mars.hibernatelistener.GeneralCreateUpdateListener;

import javax.persistence.*;

@Entity
@EntityListeners(GeneralCreateUpdateListener.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class GeneralInformation extends BusinessEntity {
    private String firstName;
    private String lastName;
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "contact_information_id")
    private ContactInformation contactInformation;
    private String desiredPosition;
    private String summary;
}
