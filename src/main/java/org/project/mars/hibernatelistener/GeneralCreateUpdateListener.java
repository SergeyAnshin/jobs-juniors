package org.project.mars.hibernatelistener;

import org.project.mars.entity.BusinessEntity;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

public class GeneralCreateUpdateListener {

    @PrePersist
    private void setCreationAndUpdateDates(BusinessEntity businessEntity) {
        businessEntity.setCreationDateTime(LocalDateTime.now());
        businessEntity.setUpdateDateTime(LocalDateTime.now());
    }

    @PreUpdate
    private void setUpdateDate(BusinessEntity businessEntity) {
        businessEntity.setUpdateDateTime(LocalDateTime.now());
    }
}
