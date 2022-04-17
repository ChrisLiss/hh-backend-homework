package ru.hh.school.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.hh.school.entity.AreaEntity;
import ru.hh.school.entity.EmployerEntity;
import ru.hh.school.entity.VacancyEntity;

import java.util.Optional;

@Repository
public class AreaDao {

    private final SessionFactory sessionFactory;

    public AreaDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

//    public Optional<AreaEntity> getByID(Integer id) {
//        Session session = sessionFactory.getCurrentSession();
//        return Optional.of(session.get(AreaEntity.class, id));
//    }

    public boolean checkConstraint(AreaEntity area) {    // Проверка area на отсутствие ссылок в таблицах Employer,
                                                         // Vacancy перед удалением

        Session session = sessionFactory.getCurrentSession();
        boolean checkEmployer = session.createQuery(
                "SELECT employ.id " +
                        "FROM EmployerEntity employ " +
                        "WHERE employ.area = :area",Integer.class)
                .setParameter("area", area)
                .getResultList()
                .isEmpty();

        boolean checkVacancy = session.createQuery(
                        "SELECT vac.id " +
                                "FROM VacancyEntity vac " +
                                "WHERE vac.area = :area",Integer.class)
                .setParameter("area", area)
                .getResultList()
                .isEmpty();

        return checkEmployer & checkVacancy;

    }
}
