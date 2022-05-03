package org.project.mars.mapper;

import org.project.mars.dto.JobInformation;
import org.project.mars.entity.Company;
import org.project.mars.entity.Job;
import org.project.mars.entity.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class JobMapper {

    public static Job mapFromJobInformation(JobInformation jobInformation) {
        if (jobInformation == null) {
            return null;
        } else {
            return Job.builder()
                    .company(Company.builder()
                            .name(jobInformation.getCompanyName())
                            .site(jobInformation.getCompanySite())
                            .jobs(new ArrayList<>())
                            .build())
                    .position(Position.builder().name(jobInformation.getPositionName()).build())
                    .employmentDate(jobInformation.getEmploymentDate())
                    .dismissalDate(jobInformation.getDismissalDate())
                    .jobResponsibilities(jobInformation.getJobResponsibilities())
                    .jobAchievements(jobInformation.getJobAchievements())
                    .build();
        }
    }

    public static Set<Job> mapFromJobInformationList(List<JobInformation> jobInformationList) {
        if (jobInformationList == null || jobInformationList.isEmpty()) {
            return null;
        } else {
            return jobInformationList.stream()
                    .map(JobMapper::mapFromJobInformation)
                    .collect(Collectors.toSet());
        }
    }
}
