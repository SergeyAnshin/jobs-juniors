package org.project.mars.dto;

import lombok.*;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.project.mars.entity.User;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class ResumeDTO {
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
    @Valid
    private List<JobInformation> jobs = new ArrayList<>();
    @Valid
    private List<EducationInformation> educationInformationList = new ArrayList<>();
    @Valid
    private List<ProjectInformation> projectInformationList = new ArrayList<>();
    @Valid
    private List<CourseInformation> courseInformationList = new ArrayList<>();
    @Valid
    private List<SkillInformation> skillInformationList = new ArrayList<>();
    private long ownerId;
}
