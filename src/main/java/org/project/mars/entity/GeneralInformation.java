package org.project.mars.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.project.mars.hibernatelistener.GeneralCreateUpdateListener;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(name = "GeneralInformation.findByResumeIdJoinContact",
                query = "SELECT gi FROM GeneralInformation gi JOIN FETCH gi.contactInformation INNER JOIN Resume r ON gi.id = r.generalInformation.id WHERE r.id = :id")
})

@Entity
@EntityListeners(GeneralCreateUpdateListener.class)
@Data
@NoArgsConstructor
@AllArgsConstructor()
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class GeneralInformation extends BusinessEntity {
    private String firstName;
    private String lastName;
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
    @JoinColumn(name = "contact_information_id")
    private ContactInformation contactInformation;
    private String desiredPosition;
    private String summary;
}
