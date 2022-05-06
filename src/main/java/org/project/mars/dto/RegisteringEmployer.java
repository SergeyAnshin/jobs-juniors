package org.project.mars.dto;

import lombok.*;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class RegisteringEmployer {
    @NotBlank
    @NotEmpty
    private String firstName;
    @NotBlank
    @NotEmpty
    private String lastName;
    @NotBlank
    @NotEmpty
    private String phoneNumber;
    @NotBlank
    @NotEmpty
    @Email(regexp = "^([\\w]*[\\.]*){1,3}@[a-z]*\\.[a-z]*$",
            message = "Email must contain only latin letters, underscores, dots and at symbol!")
    private String email;
    @NotBlank
    @NotEmpty
    private String companyName;
}
