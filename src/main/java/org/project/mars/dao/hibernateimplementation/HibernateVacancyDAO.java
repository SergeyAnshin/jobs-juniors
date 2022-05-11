package org.project.mars.dao.hibernateimplementation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.project.mars.dao.VacancyDAO;
import org.project.mars.entity.Vacancy;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class HibernateVacancyDAO implements VacancyDAO {
    private final SessionFactory sessionFactory;

    public HibernateVacancyDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Vacancy save(Vacancy vacancy) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.merge(vacancy.getCompany());
        if (vacancy.getSkills() != null && !vacancy.getSkills().isEmpty()) {
            vacancy.getSkills().stream().filter(skill -> skill.getId() != 0).forEach(currentSession::merge);
            vacancy.getSkills().stream().filter(skill -> skill.getId() == 0).forEach(currentSession::persist);
        }
        currentSession.persist(vacancy);
        return vacancy;
    }

    @Override
    public boolean exists(Vacancy vacancy) {
        Session session = sessionFactory.openSession();
        Query<Vacancy> namedQuery = session.createNamedQuery("Vacancy.exists", Vacancy.class);
        namedQuery.setParameter("name", vacancy.getName());
        namedQuery.setParameter("salary", vacancy.getSalary());
        namedQuery.setParameter("requiredExperience", vacancy.getRequiredExperience());
        namedQuery.setParameter("aboutProject", vacancy.getAboutProject());
        namedQuery.setParameter("requirements", vacancy.getRequirements());
        namedQuery.setParameter("responsibilities", vacancy.getResponsibilities());
        namedQuery.setParameter("companyName", vacancy.getCompany().getName());
        Optional<Vacancy> foundVacancy = namedQuery.uniqueResultOptional();
        session.close();
        return foundVacancy.isPresent();
    }

    @Override
    public void delete(Vacancy vacancy) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.delete(vacancy);
    }
}
