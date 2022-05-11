package org.project.mars.dao;

import org.project.mars.entity.GeneralInformation;

import java.util.Optional;

public interface GeneralInformationDAO extends BusinessEntityDAO<GeneralInformation> {

    Optional<GeneralInformation> findByResumeIdJoinContact(long id);

    boolean update(GeneralInformation generalInformation);
}
