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
public class GeneralInformationDetails {
    private long id;
    private long contactId;
    @NotEmpty
    @NotBlank
    private String firstName;
    @NotEmpty
    @NotBlank
    private String lastName;
    private String email;
    private String telegramLink;
    private String phoneNumber;
    private String linkedinLink;
    private String githubLink;
    private String location;
    private String desiredPosition;
    private String summary;
}
