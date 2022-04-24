package ru.hh.school.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.hh.school.entity.EmployerEntity;
import ru.hh.school.entity.VacancyEntity;

import java.util.List;
import java.util.Optional;

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

    public void delete(Object object) {
        if (object == null) {
            return;
        }
        Session session = sessionFactory.getCurrentSession();
        session.delete(object);
    }

//    public VacancyEntity getById(Integer id) {
//        Session session = sessionFactory.getCurrentSession();
//        return session.get(VacancyEntity.class, id);
//    }

    public Optional<VacancyEntity> getById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return Optional.of(session.get(VacancyEntity.class, id));
    }

    public void update(VacancyEntity vacancyEntity) {
        if (vacancyEntity == null) {
            return;
        }
        Session session = sessionFactory.getCurrentSession();
        session.update(vacancyEntity);
    }

    public List<VacancyEntity> getVacancies(Integer page, Integer perPage) {

        int qPage = (page == null) ? 0 : page;
        int qPerPage = (perPage == null) ? 20 : perPage;

        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("SELECT vac FROM VacancyEntity vac", VacancyEntity.class)
                .setFirstResult(qPerPage * ( (qPage-1) +1 ))
                .setMaxResults(qPerPage)
                .getResultList();
    }
}
