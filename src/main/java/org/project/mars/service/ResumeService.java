package org.project.mars.service;

import org.project.mars.dao.ResumeDAO;
import org.project.mars.dto.ResumeDTO;
import org.project.mars.entity.Job;
import org.project.mars.entity.Resume;
import org.project.mars.entity.Skill;
import org.project.mars.entity.User;
import org.project.mars.mapper.ResumeMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class ResumeService {
    private final ResumeDAO resumeDAO;
    private final SkillService skillService;
    private final JobService jobService;
    private final UserService userService;

    public ResumeService(ResumeDAO resumeDAO, SkillService skillService, JobService jobService,
                         UserService userService) {
        this.resumeDAO = resumeDAO;
        this.skillService = skillService;
        this.jobService = jobService;
        this.userService = userService;
    }

    public void save(ResumeDTO resumeDTO) {
        Resume resume = ResumeMapper.mapFromResumeDTO(resumeDTO);
        Set<Skill> skills = resume.getSkills();
        if (skills != null) {
            skillService.replaceSkillsWithPersistentIfExists(skills);
            skills.forEach(skill -> skill.addResume(resume));
            resume.setSkills(skills);
        }
        Set<Job> workExperience = resume.getWorkExperience();
        if (workExperience != null) {
            jobService.replaceCompaniesWithPersistentIfExists(workExperience);
            workExperience.forEach(job -> job.getCompany().addJob(job));
            jobService.replacePositionsWithPersistentIfExists(workExperience);
            resume.setWorkExperience(workExperience);
        }
        Optional<User> owner = userService.findByIdWithResumes(resume.getOwner().getId());
        owner.ifPresent(user -> user.addResume(resume));
        resumeDAO.save(resume);
    }
}
