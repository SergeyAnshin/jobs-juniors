package org.project.mars.mapper;

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
}
