package org.project.mars.service;

import org.project.mars.dao.GeneralInformationDAO;
import org.project.mars.dto.GeneralInformationDetails;
import org.project.mars.entity.GeneralInformation;
import org.project.mars.mapper.GeneralInformationMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class GeneralInformationService {
    private final GeneralInformationDAO generalInformationDAO;

    public GeneralInformationService(GeneralInformationDAO generalInformationDAO) {
        this.generalInformationDAO = generalInformationDAO;
    }

    public Optional<GeneralInformationDetails> getGeneralInformationDetailsByResumeId(long id) {
        Optional<GeneralInformation> generalInformation = generalInformationDAO.findByResumeIdJoinContact(id);
        return generalInformation.map(GeneralInformationMapper::mapToGeneralInformationDetails);
    }

    public boolean update(GeneralInformationDetails generalInformationDetails) {
        GeneralInformation generalInformation = GeneralInformationMapper.mapFromGeneralInformationDetails(generalInformationDetails);
        return generalInformationDAO.update(generalInformation);
    }
}
