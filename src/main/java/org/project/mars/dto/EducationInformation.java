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
public class EducationInformation {
    @NotEmpty
    @NotBlank
    private String educationalInstitution;
    @NotEmpty
    @NotBlank
    private String faculty;
    @NotEmpty
    @NotBlank
    private String specialization;
    @NotNull
    @BeforeNow(message = "Date must be before today!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate enrollmentDate;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate graduationDate;
}
