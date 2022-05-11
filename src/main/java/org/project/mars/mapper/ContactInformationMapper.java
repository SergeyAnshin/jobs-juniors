package org.project.mars.mapper;

import org.project.mars.dto.GeneralInformationDetails;
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

    public static ContactInformation mapFromGeneralInformationDetails(GeneralInformationDetails generalInformationDetails) {
        if (generalInformationDetails == null) {
            return null;
        } else {
            return ContactInformation.builder()
                    .id(generalInformationDetails.getContactId())
                    .email(generalInformationDetails.getEmail())
                    .telegramLink(generalInformationDetails.getTelegramLink())
                    .phoneNumber(generalInformationDetails.getPhoneNumber())
                    .linkedinLink(generalInformationDetails.getLinkedinLink())
                    .githubLink(generalInformationDetails.getGithubLink())
                    .location(generalInformationDetails.getLocation())
                    .build();
        }
    }
}
