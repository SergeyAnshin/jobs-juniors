package org.project.mars.dao.hibernateimplementation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.project.mars.dao.RoleDAO;
import org.project.mars.entity.Role;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class HibernateRoleDAO implements RoleDAO {
    private final SessionFactory sessionFactory;

    public HibernateRoleDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Role save(Role role) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.persist(role);
        return role;
    }

    @Override
    public boolean exists(Role role) {
        Session session = sessionFactory.openSession();
        Query<Role> namedQuery = session.createNamedQuery("Role.exists", Role.class);
        namedQuery.setParameter("name", role.getName());
        Optional<Role> foundRole = namedQuery.getResultStream().findAny();
        session.close();
        return foundRole.isPresent();
    }

    @Override
    public void delete(Role role) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.delete(role);;
    }

    @Override
    public Optional<Role> findByNameJoinUser(String name) {
        Session session = sessionFactory.openSession();
        Query<Role> namedQuery = session.createNamedQuery("Role.findByNameJoinUser", Role.class);
        namedQuery.setParameter("name", name);
        Optional<Role> foundRole = namedQuery.uniqueResultOptional();
        session.close();
        return foundRole;
    }

    @Override
    public Optional<Role> findByNameJoinEmployer(String name) {
        Session session = sessionFactory.openSession();
        Query<Role> namedQuery = session.createNamedQuery("Role.findByNameJoinEmployer", Role.class);
        namedQuery.setParameter("name", name);
        Optional<Role> foundRole = namedQuery.uniqueResultOptional();
        session.close();
        return foundRole;
    }
}
