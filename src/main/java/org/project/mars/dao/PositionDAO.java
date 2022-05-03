package org.project.mars.dao;

import org.project.mars.entity.Position;

import java.util.List;

public interface PositionDAO extends BusinessEntityDAO<Position> {

    List<Position> findAllByNameContainingIn(List<String> positionNames);
}
