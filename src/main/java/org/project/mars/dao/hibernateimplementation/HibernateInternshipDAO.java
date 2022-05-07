package org.project.mars.dao.hibernateimplementation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.project.mars.dao.InternshipDAO;
import org.project.mars.entity.Internship;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class HibernateInternshipDAO implements InternshipDAO {
    private SessionFactory sessionFactory;

    public HibernateInternshipDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Internship save(Internship internship) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.merge(internship.getCompany());
        currentSession.persist(internship);
        return internship;
    }

    @Override
    public boolean exists(Internship internship) {
        Session session = sessionFactory.openSession();
        Query<Internship> namedQuery = session.createNamedQuery("Internship.exists", Internship.class);
        namedQuery.setParameter("name", internship.getName());
        namedQuery.setParameter("companyName", internship.getCompany().getName());
        Optional<Internship> foundInternship = namedQuery.uniqueResultOptional();
        session.close();
        return foundInternship.isPresent();
    }
}
