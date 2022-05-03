package org.project.mars.mapper;

import org.project.mars.dto.SkillInformation;
import org.project.mars.entity.Skill;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SkillMapper {

    public static Skill mapFromSkillInformation(SkillInformation skillInformation) {
        if (skillInformation == null) {
            return null;
        } else {
            return Skill.builder()
                    .name(skillInformation.getName())
                    .resumes(new ArrayList<>())
                    .build();
        }
    }

    public static Set<Skill> mapFromSkillInformationList(List<SkillInformation> skillInformationList) {
        if (skillInformationList == null || skillInformationList.isEmpty()) {
            return null;
        } else {
            return skillInformationList.stream()
                    .map(SkillMapper::mapFromSkillInformation)
                    .collect(Collectors.toSet());
        }
    }
}
