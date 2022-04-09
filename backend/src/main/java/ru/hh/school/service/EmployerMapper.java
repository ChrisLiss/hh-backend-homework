package ru.hh.school.service;

import ru.hh.school.dto.EmployerDto;
import ru.hh.school.entity.EmployerEntity;

public class EmployerMapper {

    public static EmployerEntity mapDtoToEntity(EmployerDto employerDto, String comment) {
        return new EmployerEntity(employerDto.getId(), employerDto.getName(), employerDto.getDescription(), AreaMapper.mapDtoToEntity(employerDto.getArea()), comment);
    }

    public static EmployerDto mapEntityToDto(EmployerEntity employerEntity) {

        return new EmployerDto(employerEntity.getId(),
                employerEntity.getName(),
                employerEntity.getDescription(),
                employerEntity.getDateCreate(),
                AreaMapper.mapEntityToDTO(employerEntity.getArea()),
                employerEntity.getComment(),
                employerEntity.getViewsCount());
    }

}
