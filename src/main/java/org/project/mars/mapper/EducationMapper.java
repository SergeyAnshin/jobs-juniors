package org.project.mars.mapper;

import org.project.mars.dto.EducationInformation;
import org.project.mars.entity.Education;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class EducationMapper {

    public static Education mapFromEducationInformation(EducationInformation educationInformation) {
        if (educationInformation == null) {
            return null;
        } else {
            return Education.builder()
                    .educationalInstitution(educationInformation.getEducationalInstitution())
                    .faculty(educationInformation.getFaculty())
                    .specialization(educationInformation.getSpecialization())
                    .enrollmentDate(educationInformation.getEnrollmentDate())
                    .graduationDate(educationInformation.getGraduationDate())
                    .build();
        }
    }

    public static Set<Education> mapFromEducationInformationList(List<EducationInformation> educationInformationList) {
        if (educationInformationList == null || educationInformationList.isEmpty()) {
            return null;
        } else {
            return educationInformationList.stream()
                    .map(EducationMapper::mapFromEducationInformation)
                    .collect(Collectors.toSet());
        }
    }
}
