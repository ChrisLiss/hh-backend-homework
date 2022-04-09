package ru.hh.school.dao;

import jnr.ffi.annotations.In;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.hh.school.entity.SalaryEntity;

public class SalaryDao {

    private final SessionFactory sessionFactory;

    public SalaryDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public Integer save(SalaryEntity salaryEntity) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(salaryEntity);
        return salaryEntity.getId();
    }
}
