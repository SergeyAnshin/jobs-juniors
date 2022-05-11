package org.project.mars.mapper;

import org.project.mars.dto.GeneralInformationDetails;
import org.project.mars.dto.ResumeDTO;
import org.project.mars.entity.GeneralInformation;

public class GeneralInformationMapper {

    public static GeneralInformation mapFromResumeDTO(ResumeDTO resumeDTO) {
        if (resumeDTO == null) {
            return null;
        } else {
            return GeneralInformation.builder()
                    .firstName(resumeDTO.getFirstName())
                    .lastName(resumeDTO.getLastName())
                    .contactInformation(ContactInformationMapper.mapFromResumeDTO(resumeDTO))
                    .desiredPosition(resumeDTO.getDesiredPosition())
                    .summary(resumeDTO.getSummary())
                    .build();
        }
    }

    public static GeneralInformationDetails mapToGeneralInformationDetails(GeneralInformation generalInformation) {
        if (generalInformation == null) {
            return null;
        } else {
            return GeneralInformationDetails.builder()
                    .id(generalInformation.getId())
                    .contactId(generalInformation.getContactInformation().getId())
                    .firstName(generalInformation.getFirstName())
                    .lastName(generalInformation.getLastName())
                    .email(generalInformation.getContactInformation().getEmail())
                    .telegramLink(generalInformation.getContactInformation().getTelegramLink())
                    .phoneNumber(generalInformation.getContactInformation().getPhoneNumber())
                    .linkedinLink(generalInformation.getContactInformation().getLinkedinLink())
                    .githubLink(generalInformation.getContactInformation().getGithubLink())
                    .location(generalInformation.getContactInformation().getLocation())
                    .desiredPosition(generalInformation.getDesiredPosition())
                    .summary(generalInformation.getSummary())
                    .build();
        }
    }

    public static GeneralInformation mapFromGeneralInformationDetails(GeneralInformationDetails generalInformationDetails) {
        if (generalInformationDetails == null) {
            return null;
        } else {
            return GeneralInformation.builder()
                    .id(generalInformationDetails.getId())
                    .firstName(generalInformationDetails.getFirstName())
                    .lastName(generalInformationDetails.getLastName())
                    .contactInformation(ContactInformationMapper.mapFromGeneralInformationDetails(generalInformationDetails))
                    .desiredPosition(generalInformationDetails.getDesiredPosition())
                    .summary(generalInformationDetails.getSummary())
                    .build();
        }
    }
}
