package ru.hh.school.service;

import org.springframework.transaction.annotation.Transactional;
import ru.hh.school.dao.AreaDao;
import ru.hh.school.dao.VacancyDao;
import ru.hh.school.dto.VacancyDto;
import ru.hh.school.entity.AreaEntity;
import ru.hh.school.entity.EmployerEntity;
import ru.hh.school.entity.VacancyEntity;

import javax.ws.rs.NotFoundException;
import java.util.List;

public class VacancyService {

    private final VacancyDao vacancyDao;
    private final EmployerService employerService;
    private final AreaDao areaDao;

    public VacancyService(VacancyDao vacancyDao, EmployerService employerService, AreaDao areaDao) {
        this.vacancyDao = vacancyDao;
        this.employerService = employerService;
        this.areaDao = areaDao;
    }

    @Transactional
    public void create(VacancyEntity vacancyEntity) {
        vacancyDao.save(vacancyEntity);
    }

    @Transactional
    public void deleteFromFavorites(Integer id) {
        VacancyEntity vacancyEntity = vacancyDao.getById(id).orElseThrow(NotFoundException::new);
        AreaEntity area = vacancyEntity.getArea();
        vacancyDao.delete(vacancyEntity);

        // проверка перед удалением Area
        if (areaDao.checkConstraint(area)) {
            vacancyDao.delete(area);
        }
    }

    @Transactional
    public void updateInfo(VacancyDto vacancyDto) {

        VacancyEntity vacancyEntity = vacancyDao.getById(vacancyDto.getId()).orElseThrow(NotFoundException::new);
        vacancyEntity.setName(vacancyDto.getName());
        vacancyEntity.setCreatedAt(vacancyDto.getCreatedAt());

//        vacancyEntity.setArea(AreaMapper.mapDtoToEntity(vacancyDto.getArea()));
//        vacancyEntity.setSalary(VacancyMapper.mapSalaryDtoToEntity(vacancyDto.getSalary(), vacancyDto.getId()));
//        vacancyEntity.setEmployer(EmployerMapper.mapDtoToEntity(vacancyDto.getEmployer(), ""));

        vacancyDao.update(vacancyEntity);
    }

    @Transactional
    public void updateViewsCountVacancyAndEmployer(VacancyEntity vacancyEntity) {
        vacancyEntity.setViewsCount(vacancyEntity.getViewsCount() + 1);
        EmployerEntity employerEntity = vacancyEntity.getEmployer();
        vacancyDao.update(vacancyEntity);
        employerService.updateViewsCount(employerEntity);
    }

    @Transactional
    public List<VacancyEntity> getVacancies(Integer page, Integer perPage) {
        return vacancyDao.getVacancies(page, perPage);
    }
}
