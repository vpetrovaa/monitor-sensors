package com.agsr.monitor_sensors.web.mapper;

import com.agsr.monitor_sensors.domain.monitor.Unit;
import com.agsr.monitor_sensors.web.dto.UnitDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = SensorMapper.class)
public interface UnitMapper {

    Unit toEntity(UnitDto unitDto);

    UnitDto toDto(Unit unit);

}
