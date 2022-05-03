package org.project.mars.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.project.mars.hibernatelistener.GeneralCreateUpdateListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;

@Entity
@EntityListeners(GeneralCreateUpdateListener.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class ContactInformation extends BusinessEntity{
    private String email;
    private String telegramLink;
    private String phoneNumber;
    private String linkedinLink;
    private String githubLink;
    private String location;
}
