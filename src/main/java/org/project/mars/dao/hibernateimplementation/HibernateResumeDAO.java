package org.project.mars.dao.hibernateimplementation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.project.mars.dao.ResumeDAO;
import org.project.mars.entity.Job;
import org.project.mars.entity.Resume;
import org.springframework.stereotype.Repository;

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
}
