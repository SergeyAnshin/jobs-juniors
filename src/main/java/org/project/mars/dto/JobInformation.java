package org.project.mars.dto;

import lombok.*;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.project.mars.validation.constraints.BeforeNow;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class JobInformation {
    @NotEmpty
    @NotBlank
    private String companyName;
    @NotEmpty
    @NotBlank
    private String companySite;
    @NotEmpty
    @NotBlank
    private String positionName;
    @NotNull
    @BeforeNow(message = "Date must be before today!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate employmentDate;
    @BeforeNow(message = "Date must be before today!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dismissalDate;
    @NotEmpty
    @NotBlank
    private String jobResponsibilities;
    @NotEmpty
    @NotBlank
    private String jobAchievements;
}
