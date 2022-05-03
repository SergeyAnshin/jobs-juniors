package org.project.mars.dto;

import lombok.*;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class ProjectInformation {
    @NotEmpty
    @NotBlank
    private String name;
    @NotEmpty
    @NotBlank
    private String description;
    @NotEmpty
    @NotBlank
    private String tasks;
    @NotEmpty
    @NotBlank
    private String stack;
    @NotEmpty
    @NotBlank
    private String link;
}
