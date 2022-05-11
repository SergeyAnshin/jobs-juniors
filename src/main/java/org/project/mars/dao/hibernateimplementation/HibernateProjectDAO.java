package org.project.mars.dao.hibernateimplementation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.project.mars.dao.ProjectDAO;
import org.project.mars.entity.Position;
import org.project.mars.entity.Project;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class HibernateProjectDAO implements ProjectDAO {
    private final SessionFactory sessionFactory;

    public HibernateProjectDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Project save(Project project) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.persist(project);
        return project;
    }

    @Override
    public boolean exists(Project project) {
        Session session = sessionFactory.openSession();
        Query<Project> namedQuery = session.createNamedQuery("Project.exists", Project.class);
        namedQuery.setParameter("link", project.getLink());
        Optional<Project> foundProject = namedQuery.uniqueResultOptional();
        session.close();
        return foundProject.isPresent();
    }

    @Override
    public void delete(Project project) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.delete(project);
    }

    @Override
    public List<Project> findAllByOpenSource() {
        Session session = sessionFactory.openSession();
        Query<Project> namedQuery = session.createNamedQuery("Project.findAllByOpenSource", Project.class);
        List<Project> projects = namedQuery.list();
        session.close();
        return projects;
    }
}
