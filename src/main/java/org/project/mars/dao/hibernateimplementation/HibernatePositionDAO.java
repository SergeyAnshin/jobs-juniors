package org.project.mars.dao.hibernateimplementation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.project.mars.dao.PositionDAO;
import org.project.mars.entity.Position;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class HibernatePositionDAO implements PositionDAO {
    private final SessionFactory sessionFactory;

    public HibernatePositionDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Position save(Position position) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.persist(position);
        return position;
    }

    @Override
    public boolean exists(Position position) {
        Session session = sessionFactory.openSession();
        Query<Position> namedQuery = session.createNamedQuery("Position.exists", Position.class);
        namedQuery.setParameter("name", position.getName());
        Optional<Position> foundPosition = namedQuery.uniqueResultOptional();
        session.close();
        return foundPosition.isPresent();
    }

    @Override
    public void delete(Position position) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.delete(position);
    }

    @Override
    public List<Position> findAllByNameContainingIn(List<String> positionNames) {
        Session session = sessionFactory.openSession();
        Query<Position> namedQuery = session.createNamedQuery("Position.findAllByNameContainingIn", Position.class);
        namedQuery.setParameterList("names", positionNames);
        List<Position> positions = namedQuery.list();
        session.close();
        return positions;
    }
}
