package org.project.mars.mapper;

import org.project.mars.dto.CourseInformation;
import org.project.mars.entity.Course;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CourseMapper {

    public static Course mapFromCourseInformation(CourseInformation courseInformation) {
        if (courseInformation == null) {
            return null;
        } else {
            return Course.builder()
                    .name(courseInformation.getName())
                    .courseOwner(courseInformation.getCourseOwner())
                    .courseLink(courseInformation.getCourseLink())
                    .build();
        }
    }

    public static Set<Course> mapFromCourseInformationList(List<CourseInformation> courseInformationList) {
        if (courseInformationList == null || courseInformationList.isEmpty()) {
            return null;
        } else {
            return courseInformationList.stream()
                    .map(CourseMapper::mapFromCourseInformation)
                    .collect(Collectors.toSet());
        }
    }
}
