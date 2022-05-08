package org.project.mars.dto;

import lombok.*;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class VacancyDetails {
    @NotEmpty
    @NotBlank
    private String name;
    private String salary;
    private String requiredExperience;
    private String aboutCompany;
    private String aboutCustomer;
    private String aboutProject;
    private String requirements;
    private String niceToHave;
    private String responsibilities;
    private String companyAdvantages;
    private String additionalInformation;
    @Valid
    private List<SkillInformation> skillInformationList = new ArrayList<>();
    private String companyName;
}
