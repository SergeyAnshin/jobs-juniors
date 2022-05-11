package org.project.mars.dao.hibernateimplementation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.project.mars.dao.GeneralInformationDAO;
import org.project.mars.entity.GeneralInformation;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class HibernateGeneralInformationDAO implements GeneralInformationDAO {
    private final SessionFactory sessionFactory;

    public HibernateGeneralInformationDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public GeneralInformation save(GeneralInformation generalInformation) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.persist(generalInformation);
        return generalInformation;
    }

    @Override
    public boolean exists(GeneralInformation generalInformation) {
        Session session = sessionFactory.openSession();
        GeneralInformation foundGeneralInformation = session.find(GeneralInformation.class, generalInformation.getId());
        session.close();
        return foundGeneralInformation != null;
    }

    @Override
    public void delete(GeneralInformation generalInformation) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.delete(generalInformation);
    }

    @Override
    public Optional<GeneralInformation> findByResumeIdJoinContact(long id) {
        Session session = sessionFactory.openSession();
        Query<GeneralInformation> namedQuery = session.createNamedQuery("GeneralInformation.findByResumeIdJoinContact", GeneralInformation.class);
        namedQuery.setParameter("id", id);
        Optional<GeneralInformation> generalInformation = namedQuery.uniqueResultOptional();
        session.close();
        return generalInformation;
    }

    @Override
    public boolean update(GeneralInformation generalInformation) {
        Session currentSession = sessionFactory.getCurrentSession();
        GeneralInformation updateGeneralInformation = (GeneralInformation) currentSession.merge(generalInformation);
        return updateGeneralInformation.equals(generalInformation);
    }
}
