package org.project.mars.mapper;

import org.project.mars.dto.ResumeDTO;
import org.project.mars.entity.ContactInformation;

public class ContactInformationMapper {

    public static ContactInformation mapFromResumeDTO(ResumeDTO resumeDTO) {
        if (resumeDTO == null) {
            return null;
        } else {
            return ContactInformation.builder()
                    .email(resumeDTO.getEmail())
                    .telegramLink(resumeDTO.getTelegramLink())
                    .phoneNumber(resumeDTO.getPhoneNumber())
                    .linkedinLink(resumeDTO.getLinkedinLink())
                    .githubLink(resumeDTO.getGithubLink())
                    .location(resumeDTO.getLocation())
                    .build();
        }
    }
}
