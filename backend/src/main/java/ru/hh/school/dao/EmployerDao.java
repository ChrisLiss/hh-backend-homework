package ru.hh.school.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.hh.school.entity.EmployerEntity;

import java.util.List;
import java.util.Optional;

@Repository
public class EmployerDao {

    private final SessionFactory sessionFactory;

    public EmployerDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void save(EmployerEntity employer) {
        if (employer == null) {
            return;
        }
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(employer);

    }

    public void update(EmployerEntity employer) {
        if (employer == null) {
            return;
        }
        Session session = sessionFactory.getCurrentSession();
        session.update(employer);
    }

    public EmployerEntity getByID(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(EmployerEntity.class, id);
    }

    public void delete(EmployerEntity employerEntity) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(employerEntity);
    }

    public List<EmployerEntity> getEmployers() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("SELECT employ FROM EmployerEntity employ", EmployerEntity.class).getResultList();
    }


}
