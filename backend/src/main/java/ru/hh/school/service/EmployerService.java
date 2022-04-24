package ru.hh.school.service;

import org.springframework.transaction.annotation.Transactional;
import ru.hh.school.dao.AreaDao;
import ru.hh.school.dao.EmployerDao;
import ru.hh.school.dto.EmployerDto;
import ru.hh.school.entity.AreaEntity;
import ru.hh.school.entity.EmployerEntity;

import javax.ws.rs.NotFoundException;
import java.util.List;

public class EmployerService {

    private final EmployerDao employerDao;
    private final AreaDao areaDao;

    public EmployerService(EmployerDao employerDao, AreaDao areaDao) {
        this.employerDao = employerDao;
        this.areaDao = areaDao;
    }

    @Transactional
    public void create(EmployerEntity employerEntity) {
        employerDao.save(employerEntity);
    }

    @Transactional
    public void updateInfo(EmployerDto employerDto) {
        EmployerEntity employerEntity = employerDao.getByID(employerDto.getId()).orElseThrow(NotFoundException::new);
        employerEntity.setName(employerDto.getName());
        employerEntity.setDescription(employerDto.getDescription());
        // Area
        employerDao.update(employerEntity);
    }

    @Transactional
    public void updateComment(Integer id, String comment) {
        EmployerEntity employerEntity = employerDao.getByID(id).orElseThrow(NotFoundException::new);
        employerEntity.setComment(comment);
        employerDao.update(employerEntity);
    }

    @Transactional
    public void updateViewsCount(EmployerEntity employerEntity) {
        employerEntity.setViewsCount(employerEntity.getViewsCount() + 1);
        employerDao.update(employerEntity);
    }

    @Transactional
    public void deleteFromFavorites(Integer id) {

        EmployerEntity employerEntity = employerDao.getByID(id).orElseThrow(NotFoundException::new);
        AreaEntity area = employerEntity.getArea();
        employerDao.delete(employerEntity);

        // проверка перед удалением Area
        if (areaDao.checkConstraint(area)) {
            employerDao.delete(area);
        }

    }

    @Transactional
    public List<EmployerEntity> getEmployers(Integer page, Integer perPage) {
        return employerDao.getEmployers(page, perPage);
    }


}
