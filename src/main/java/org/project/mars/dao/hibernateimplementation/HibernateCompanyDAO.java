package org.project.mars.dao.hibernateimplementation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.project.mars.dao.CompanyDAO;
import org.project.mars.entity.Company;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class HibernateCompanyDAO implements CompanyDAO {
    private final SessionFactory sessionFactory;

    public HibernateCompanyDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Company save(Company company) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.persist(company);
        return company;
    }

    @Override
    public boolean exists(Company company) {
        Session session = sessionFactory.openSession();
        Query<Company> namedQuery = session.createNamedQuery("Company.exists", Company.class);
        namedQuery.setParameter("name", company.getName());
        Optional<Company> foundCompany = namedQuery.uniqueResultOptional();
        session.close();
        return foundCompany.isPresent();
    }

    @Override
    public List<Company> findAllByNameContainingIn(List<String> companyNames) {
        Session session = sessionFactory.openSession();
        Query<Company> namedQuery = session.createNamedQuery("Company.findAllByNameContainingIn", Company.class);
        namedQuery.setParameterList("names", companyNames);
        List<Company> companies = namedQuery.list();
        session.close();
        return companies;
    }

    @Override
    public Optional<Company> findByNameJoinEmployer(String name) {
        Session session = sessionFactory.openSession();
        Query<Company> namedQuery = session.createNamedQuery("Company.findByNameJoinEmployer", Company.class);
        namedQuery.setParameter("name", name);
        Optional<Company> foundCompany = namedQuery.uniqueResultOptional();
        session.close();
        return foundCompany;
    }
}
