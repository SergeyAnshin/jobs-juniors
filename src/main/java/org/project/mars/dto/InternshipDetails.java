package org.project.mars.dto;

import lombok.*;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.project.mars.validation.constraints.BeforeNow;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Future;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class InternshipDetails {
    @NotEmpty
    @NotBlank
    private String name;
    @NotEmpty
    @NotBlank
    private String technology;
    @BeforeNow(message = "Date must be before today!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    @Future
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate finishDate;
    @NotEmpty
    @NotBlank
    private String description;
    @NotEmpty
    @NotBlank
    private String stack;
    @NotEmpty
    @NotBlank
    private String requirements;
    @NotEmpty
    @NotBlank
    private String contact;
}
