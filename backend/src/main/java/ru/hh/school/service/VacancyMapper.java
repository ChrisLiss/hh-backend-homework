package ru.hh.school.service;

import ru.hh.school.dto.SalaryDto;
import ru.hh.school.dto.VacancyDto;
import ru.hh.school.entity.SalaryEntity;
import ru.hh.school.entity.VacancyEntity;

public class VacancyMapper {

    public static VacancyEntity mapDtoToEntity (VacancyDto vacancyDto, String comment) {
        return new VacancyEntity(vacancyDto.getName(),
                                 AreaMapper.mapDtoToEntity(vacancyDto.getArea()),
                                 mapSalaryDtoToEntity(vacancyDto.getSalary()),
                                 vacancyDto.getCreated_at(),
                                 EmployerMapper.mapDtoToEntity(vacancyDto.getEmployer(), ""),
                                 comment);
    }

    private static SalaryEntity mapSalaryDtoToEntity(SalaryDto salaryDto) {
        return new SalaryEntity(salaryDto.getFrom(), salaryDto.getTo(), salaryDto.getCurrency(), salaryDto.getGross());
    }
}
