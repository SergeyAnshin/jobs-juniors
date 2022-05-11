package org.project.mars.dao;

import org.project.mars.entity.BusinessEntity;
import org.project.mars.entity.Resume;

public interface BusinessEntityDAO<T extends BusinessEntity> {

    T save(T businessEntity);

    boolean exists(T businessEntity);

    void delete(T businessEntity);
}
