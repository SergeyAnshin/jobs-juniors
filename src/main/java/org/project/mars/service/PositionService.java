package org.project.mars.service;

import org.project.mars.dao.hibernateimplementation.HibernatePositionDAO;
import org.project.mars.entity.Position;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import java.util.stream.Collectors;

@Service
@Transactional
public class PositionService {
    private final HibernatePositionDAO positionDAO;

    public PositionService(HibernatePositionDAO positionDAO) {
        this.positionDAO = positionDAO;
    }

    public List<Position> findAllByNameContainingIn(List<Position> positions) {
        List<String> positionNames = positions.stream()
                .map(Position::getName)
                .collect(Collectors.toList());
        return positionDAO.findAllByNameContainingIn(positionNames);
    }
}
