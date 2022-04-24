package ru.hh.school.service;

import ru.hh.school.dto.AreaDto;
import ru.hh.school.entity.AreaEntity;

public class AreaMapper {

    public static AreaDto mapEntityToDTO(AreaEntity areaEntity) {
        if (areaEntity == null) {
            return null;
        }
        return new AreaDto(areaEntity.getId(), areaEntity.getName());
    }

    public static AreaEntity mapDtoToEntity(AreaDto areaDto) {
        if (areaDto == null) {
            return null;
        }
        return new AreaEntity(areaDto.getId(), areaDto.getName());
    }
}
