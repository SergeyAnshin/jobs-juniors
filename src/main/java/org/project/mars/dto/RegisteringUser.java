package org.project.mars.dto;

import lombok.*;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class RegisteringUser {
    @NotBlank
    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z]*$",
            message = "First name must contain only latin letters!")
    private String firstName;
    @NotBlank
    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z]*$",
            message = "Last name must contain only latin letters!")
    private String lastName;
    @NotBlank
    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z_.]*$",
            message = "Username must contain only latin letters, underscores and dots!")
    private String username;
    @NotBlank
    @NotEmpty
    @Email(regexp = "^([\\w]*[\\.]*){1,3}@[a-z]*\\.[a-z]*$",
            message = "Email must contain only latin letters, underscores, dots and at symbol!")
    private String email;
    @NotBlank
    @NotEmpty
    @Pattern(regexp = "^[^\\s]{8,30}$",
            message = "Password must be at least 8 and not more than 30 non-space characters!")
    private String password;
}
