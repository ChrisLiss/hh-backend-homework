package ru.hh.school.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.hh.school.entity.VacancyEntity;

@Repository
public class VacancyDao {

    private final SessionFactory sessionFactory;

    public VacancyDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void save(VacancyEntity vacancy) {
        if (vacancy == null) {
            return;
        }
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(vacancy);
    }
}
