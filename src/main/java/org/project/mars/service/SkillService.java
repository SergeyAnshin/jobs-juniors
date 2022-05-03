package org.project.mars.service;

import org.project.mars.dao.SkillDAO;
import org.project.mars.entity.Skill;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class SkillService {
    private final SkillDAO skillDAO;

    public SkillService(SkillDAO skillDAO) {
        this.skillDAO = skillDAO;
    }

    void replaceSkillsWithPersistentIfExists(Set<Skill> skills) {
        List<String> skillNames = skills.stream()
                .map(Skill::getName)
                .collect(Collectors.toList());
        List<Skill> existingSkills = skillDAO.findAllByNameContainingIn(skillNames);
        skills.forEach(skill -> {
            int existingSkillIndex;
            if ((existingSkillIndex = existingSkills.indexOf(skill)) >= 0) {
                skills.remove(skill);
                skills.add(existingSkills.get(existingSkillIndex));
            }
        });
    }
}
