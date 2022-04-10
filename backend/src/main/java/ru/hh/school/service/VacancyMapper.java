package ru.hh.school.service;

import ru.hh.school.dto.SalaryDto;
import ru.hh.school.dto.VacancyDto;
import ru.hh.school.entity.SalaryEntity;
import ru.hh.school.entity.VacancyEntity;

public class VacancyMapper {

    public static VacancyEntity mapDtoToEntity (VacancyDto vacancyDto, String comment) {
        return new VacancyEntity(vacancyDto.getId(),
                                 vacancyDto.getName(),
                                 AreaMapper.mapDtoToEntity(vacancyDto.getArea()),
                                 mapSalaryDtoToEntity(vacancyDto.getSalary(), vacancyDto.getId()),
                                 vacancyDto.getCreatedAt(),
                                 EmployerMapper.mapDtoToEntity(vacancyDto.getEmployer(), ""),
                                 comment);
    }

    public static VacancyDto mapEntityToDto(VacancyEntity vacancyEntity) {
        return new VacancyDto(vacancyEntity.getId(),
                              vacancyEntity.getName(),
                              AreaMapper.mapEntityToDTO(vacancyEntity.getArea()),
                              mapSalaryEntityToDto(vacancyEntity.getSalary()),
                              vacancyEntity.getCreatedAt(),
                              EmployerMapper.mapEntityToDto(vacancyEntity.getEmployer()),
                              vacancyEntity.getDateCreate(),
                              vacancyEntity.getViewsCount(),
                              vacancyEntity.getComment());

    }

    public static SalaryEntity mapSalaryDtoToEntity(SalaryDto salaryDto, Integer salaryId) {
        if (salaryDto == null) {
            return null;
        }
        return new SalaryEntity(salaryId,salaryDto.getFrom(), salaryDto.getTo(), salaryDto.getCurrency(), salaryDto.getGross());
    }

    public static SalaryDto mapSalaryEntityToDto(SalaryEntity salaryEntity) {
        if (salaryEntity == null) {
            return null;
        }
        return new SalaryDto(salaryEntity.getFrom(), salaryEntity.getTo(), salaryEntity.getCurrency(), salaryEntity.getGross());
    }
}
