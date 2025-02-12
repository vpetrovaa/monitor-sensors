package com.agsr.monitor_sensors.web.mapper;

import com.agsr.monitor_sensors.domain.monitor.Type;
import com.agsr.monitor_sensors.web.dto.monitor.TypeDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = SensorMapper.class)
public interface TypeMapper {

    Type toEntity(TypeDto typeDto);

    TypeDto toDto(Type type);
}
