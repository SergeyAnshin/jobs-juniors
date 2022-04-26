package org.project.mars.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class RegisteringUser {
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
}
