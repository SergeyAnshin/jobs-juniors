package org.project.mars.dao.hibernateimplementation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.project.mars.dao.ResumeDAO;
import org.project.mars.entity.Job;
import org.project.mars.entity.Resume;
import org.project.mars.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HibernateResumeDAO implements ResumeDAO {
    private final SessionFactory sessionFactory;

    public HibernateResumeDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Resume save(Resume resume) {
        Session currentSession = sessionFactory.getCurrentSession();

        if (resume.getSkills() != null && !resume.getSkills().isEmpty()) {
            resume.getSkills().stream().filter(skill -> skill.getId() != 0).forEach(currentSession::merge);
            resume.getSkills().stream().filter(skill -> skill.getId() == 0).forEach(currentSession::persist);
        }

        if (resume.getWorkExperience() != null && !resume.getWorkExperience().isEmpty()) {
            resume.getWorkExperience().stream().map(Job::getCompany).filter(company -> company.getId() != 0).forEach(currentSession::merge);
            resume.getWorkExperience().stream().map(Job::getCompany).filter(company -> company.getId() == 0).forEach(currentSession::persist);
            resume.getWorkExperience().stream().map(Job::getPosition).filter(position -> position.getId() != 0).forEach(currentSession::merge);
            resume.getWorkExperience().stream().map(Job::getPosition).filter(position -> position.getId() == 0).forEach(currentSession::persist);
        }

        currentSession.persist(resume);
        return resume;
    }

    @Override
    public boolean exists(Resume resume) {
        if (resume.getId() == 0) {
            return false;
        } else {
            Session session = sessionFactory.openSession();
            Resume foundResume = session.find(Resume.class, resume.getId());
            session.close();
            return foundResume != null;
        }
    }

    @Override
    public void delete(Resume resume) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.delete(resume);
    }

    @Override
    public List<Resume> findAllByUserId(long id) {
        Session session = sessionFactory.openSession();
        Query<Resume> namedQuery = session.createNamedQuery("Resume.findAllByUserId", Resume.class);
        namedQuery.setParameter("userId", id);
        List<Resume> resumes = namedQuery.list();
        session.close();
        return resumes;
    }

    @Override
    public Resume findById(long resumeId) {
        Session session = sessionFactory.openSession();
        Resume resume = session.find(Resume.class, resumeId);
        session.close();
        return resume;
    }
}
