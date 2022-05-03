package org.project.mars.dao.hibernateimplementation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.project.mars.dao.SkillDAO;
import org.project.mars.entity.Skill;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class HibernateSkillDAO implements SkillDAO {
    private final SessionFactory sessionFactory;

    public HibernateSkillDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Skill save(Skill skill) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.persist(skill);
        return skill;
    }

    @Override
    public boolean exists(Skill skill) {
        Session session = sessionFactory.openSession();
        Query<Skill> namedQuery = session.createNamedQuery("Skill.exists", Skill.class);
        namedQuery.setParameter("name", skill.getName());
        Optional<Skill> foundSkill = namedQuery.getResultStream().findAny();
        session.close();
        return foundSkill.isPresent();
    }

    @Override
    public List<Skill> findAllByNameContainingIn(List<String> skillNames) {
        Session session = sessionFactory.openSession();
        Query<Skill> namedQuery = session.createNamedQuery("Skill.findAllByNameContainingIn", Skill.class);
        namedQuery.setParameterList("names", skillNames);
        List<Skill> skills = namedQuery.list();
        session.close();
        return skills;
    }
}
