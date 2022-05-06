package org.project.mars.dao.hibernateimplementation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.project.mars.dao.EmployerDAO;
import org.project.mars.entity.Employer;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class HibernateEmployerDAO implements EmployerDAO {
    private final SessionFactory sessionFactory;

    public HibernateEmployerDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Employer save(Employer employer) {
        Session currentSession = sessionFactory.getCurrentSession();
        if (employer.getCompany().getId() == 0) {
            currentSession.persist(employer.getCompany());
        } else {
            currentSession.merge(employer.getCompany());
        }
        currentSession.persist(employer);
        return employer;
    }

    @Override
    public boolean exists(Employer employer) {
        Session session = sessionFactory.openSession();
        Query<Employer> namedQuery = session.createNamedQuery("Employer.exists", Employer.class);
        namedQuery.setParameter("email", employer.getEmail());
        Optional<Employer> foundEmployer = namedQuery.getResultStream().findAny();
        session.close();
        return foundEmployer.isPresent();
    }

    @Override
    public Optional<Employer> findByEmail(String email) {
        Session session = sessionFactory.openSession();
        Query<Employer> namedQuery = session.createNamedQuery("Employer.findByEmail", Employer.class);
        namedQuery.setParameter("email", email);
        Optional<Employer> employer = namedQuery.uniqueResultOptional();
        session.close();
        return employer;
    }
}
