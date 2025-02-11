package com.agsr.monitor_sensors.web.controller;

import com.agsr.monitor_sensors.domain.monitor.Sensor;
import com.agsr.monitor_sensors.service.SensorService;
import com.agsr.monitor_sensors.web.dto.SensorDto;
import com.agsr.monitor_sensors.web.mapper.SensorMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
@RequestMapping("api/v1/sensors")
@RequiredArgsConstructor
public class MonitorSensorController {

    private final SensorService sensorService;
    private final SensorMapper sensorMapper;

    @PostMapping
    public SensorDto create(@Valid @RequestBody SensorDto sensorDto) {
        Sensor sensor = sensorMapper.toEntity(sensorDto);
        sensor = sensorService.create(sensor);
        return sensorMapper.toDto(sensor);
    }

    @GetMapping("/{id}")
    public SensorDto findById(@PathVariable Long id) {
        Sensor sensor = sensorService.findById(id);
        return sensorMapper.toDto(sensor);
    }

    @GetMapping
    public List<SensorDto> findAll() {
        List<Sensor> sensors = sensorService.findAll();
        return sensorMapper.toDtoList(sensors);
    }

    @PutMapping("/{id}")
    public SensorDto update(@PathVariable Long id, @Valid @RequestBody SensorDto sensorDto) {
        Sensor sensor = sensorMapper.toEntity(sensorDto);
        sensor = sensorService.update(id, sensor);
        return sensorMapper.toDto(sensor);
    }

    @DeleteMapping("/{id}")
    public void deleteSensor(@PathVariable Long id) {
        sensorService.delete(id);
    }

}
