package org.project.mars.dao;

import org.project.mars.entity.Resume;
import org.project.mars.entity.User;

import java.util.List;

public interface ResumeDAO extends BusinessEntityDAO<Resume> {
    List<Resume> findAllByUserId(long id);

    Resume findById(long resumeId);
}
