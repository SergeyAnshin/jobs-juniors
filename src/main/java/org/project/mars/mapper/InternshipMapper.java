package org.project.mars.mapper;

import org.project.mars.dto.InternshipDetails;
import org.project.mars.entity.Company;
import org.project.mars.entity.Internship;

public class InternshipMapper {

    public static Internship mapFromInternshipDetails(InternshipDetails internshipDetails) {
        if (internshipDetails == null) {
            return null;
        } else {
            return Internship.builder()
                    .name(internshipDetails.getName())
                    .technology(internshipDetails.getTechnology())
                    .startDate(internshipDetails.getStartDate())
                    .finishDate(internshipDetails.getFinishDate())
                    .description(internshipDetails.getDescription())
                    .stack(internshipDetails.getStack())
                    .requirements(internshipDetails.getRequirements())
                    .contact(internshipDetails.getContact())
                    .company(Company.builder()
                            .name(internshipDetails.getCompanyName())
                            .build())
                    .build();
        }
    }
}
