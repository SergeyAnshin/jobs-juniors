package org.project.mars.dao.hibernateimplementation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.project.mars.dao.UserDAO;
import org.project.mars.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class HibernateUserDAO implements UserDAO {
    private final SessionFactory sessionFactory;

    public HibernateUserDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public User save(User user) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.persist(user);
        return user;
    }

    @Override
    public boolean exists(User user) {
        Session session = sessionFactory.openSession();
        Query<User> namedQuery = session.createNamedQuery("User.exists", User.class);
        namedQuery.setParameter("username", user.getUsername());
        namedQuery.setParameter("email", user.getEmail());
        Optional<User> foundUser = namedQuery.getResultStream().findAny();
        session.close();
        return foundUser.isPresent();
    }

    @Override
    public Optional<User> findByUsername(String username) {
        Session session = sessionFactory.openSession();
        Query<User> namedQuery = session.createNamedQuery("User.findByUsername", User.class);
        namedQuery.setParameter("username", username);
        Optional<User> user = namedQuery.uniqueResultOptional();
        session.close();
        return user;
    }
}
