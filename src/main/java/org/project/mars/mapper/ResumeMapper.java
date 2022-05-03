package org.project.mars.mapper;

import org.project.mars.dto.ResumeDTO;
import org.project.mars.entity.Resume;

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
                    .build();
        }
    }
}
