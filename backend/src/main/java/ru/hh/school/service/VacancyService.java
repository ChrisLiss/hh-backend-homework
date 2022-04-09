package ru.hh.school.service;

import org.springframework.transaction.annotation.Transactional;
import ru.hh.school.dao.SalaryDao;
import ru.hh.school.dao.VacancyDao;
import ru.hh.school.entity.VacancyEntity;

public class VacancyService {

    private final VacancyDao vacancyDao;
    private final SalaryDao salaryDao;

    public VacancyService(VacancyDao vacancyDao, SalaryDao salaryDao) {
        this.vacancyDao = vacancyDao;
        this.salaryDao = salaryDao;
    }

    @Transactional
    public void create(VacancyEntity vacancyEntity) {
        Integer salaryId = salaryDao.save(vacancyEntity.getSalary());
        vacancyDao.save(vacancyEntity);
    }
}
