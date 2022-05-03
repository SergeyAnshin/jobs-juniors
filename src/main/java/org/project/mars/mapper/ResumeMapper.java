package org.project.mars.mapper;

import org.project.mars.dto.ResumeDTO;
import org.project.mars.entity.Resume;
import org.project.mars.entity.User;

public class ResumeMapper {

    public static Resume mapFromResumeDTO(ResumeDTO resumeDTO) {
        if (resumeDTO == null) {
            return null;
        } else {
            return Resume.builder()
                    .generalInformation(GeneralInformationMapper.mapFromResumeDTO(resumeDTO))
                    .workExperience(JobMapper.mapFromJobInformationList(resumeDTO.getJobs()))
                    .projects(ProjectMapper.mapFromProjectInformationList(resumeDTO.getProjectInformationList()))
                    .education(EducationMapper.mapFromEducationInformationList(resumeDTO.getEducationInformationList()))
                    .courses(CourseMapper.mapFromCourseInformationList(resumeDTO.getCourseInformationList()))
                    .skills(SkillMapper.mapFromSkillInformationList(resumeDTO.getSkillInformationList()))
                    .owner(User.builder().id(resumeDTO.getOwnerId()).build())
                    .build();
        }
    }
}
