package com.agsr.monitor_sensors.web.mapper;

import com.agsr.monitor_sensors.domain.monitor.Sensor;
import com.agsr.monitor_sensors.web.dto.SensorDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SensorMapper {

    Sensor toEntity(SensorDto sensorDto);

    SensorDto toDto(Sensor sensor);

    List<SensorDto> toDtoList(List<Sensor> sensor);

}
