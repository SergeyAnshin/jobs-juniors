package org.project.mars.dao;

import org.project.mars.entity.BusinessEntity;

public interface BusinessEntityDAO<T extends BusinessEntity> {

    T save(T businessEntity);

    boolean exists(T businessEntity);
}
