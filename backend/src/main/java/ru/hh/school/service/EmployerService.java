package ru.hh.school.service;

import org.springframework.transaction.annotation.Transactional;
import ru.hh.school.dao.EmployerDao;
import ru.hh.school.dto.EmployerDto;
import ru.hh.school.entity.EmployerEntity;

import javax.ws.rs.NotFoundException;
import java.util.List;

public class EmployerService {

    private final EmployerDao employerDao;

    public EmployerService(EmployerDao employerDao) {
        this.employerDao = employerDao;
    }

    @Transactional
    public void create(EmployerEntity employerEntity) {
        employerDao.save(employerEntity);
    }

    @Transactional
    public void updateInfo(EmployerDto employerDto) {
        EmployerEntity employerEntity = employerDao.getByID(employerDto.getId());
        employerEntity.setName(employerDto.getName());
        employerEntity.setDescription(employerDto.getDescription());
        // Area
        employerDao.update(employerEntity);
    }

    @Transactional
    public void updateComment(Integer id, String comment) {
        EmployerEntity employerEntity = employerDao.getByID(id);
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
        employerDao.delete(employerDao.getByID(id));
    }

    @Transactional
    public List<EmployerEntity> getEmployers(Integer page, Integer perPage) {
        return employerDao.getEmployers(page, perPage);
    }


}
