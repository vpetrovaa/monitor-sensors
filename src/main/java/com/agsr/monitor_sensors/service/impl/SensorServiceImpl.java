package com.agsr.monitor_sensors.service.impl;

import com.agsr.monitor_sensors.domain.exception.IllegalArgumentException;
import com.agsr.monitor_sensors.domain.exception.ResourceDoesNotExistException;
import com.agsr.monitor_sensors.domain.monitor.Sensor;
import com.agsr.monitor_sensors.domain.monitor.Type;
import com.agsr.monitor_sensors.domain.monitor.Unit;
import com.agsr.monitor_sensors.repository.SensorRepository;
import com.agsr.monitor_sensors.service.SensorService;
import com.agsr.monitor_sensors.service.TypeService;
import com.agsr.monitor_sensors.service.UnitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SensorServiceImpl implements SensorService {

    private final SensorRepository sensorRepository;
    private final TypeService typeService;
    private final UnitService unitService;

    @Override
    public Sensor create(Sensor sensor) {
        Type type = typeService.findById(sensor.getType().getId());
        Unit unit = unitService.findById(sensor.getUnit().getId());
        validateTypeAndUnit(sensor, type, unit);
        Sensor sensorCreated = Sensor.builder()
                .name(sensor.getName())
                .model(sensor.getModel())
                .rangeFrom(sensor.getRangeFrom())
                .rangeTo(sensor.getRangeTo())
                .type(type)
                .unit(unit)
                .location(sensor.getLocation())
                .description(sensor.getDescription())
                .build();
        return sensorRepository.save(sensorCreated);
    }

    @Override
    public Sensor findById(Long id) {
        return sensorRepository.findById(id)
                .orElseThrow(() -> new ResourceDoesNotExistException(
                        "Sensor with id " + id + " does not exist"
                ));
    }

    @Override
    public List<Sensor> findAll() {
        return sensorRepository.findAll();
    }

    @Override
    public List<Sensor> findByNameOrModel(String searchText) {
        return sensorRepository.findByNameOrModel(searchText);
    }

    @Override
    public Sensor update(Long id, Sensor sensor) {
        Sensor sensorFromDb = findById(id);
        Type type = typeService.findById(sensor.getType().getId());
        Unit unit = unitService.findById(sensor.getUnit().getId());
        validateTypeAndUnit(sensor, type, unit);
        sensorFromDb = Sensor.builder()
                .id(sensorFromDb.getId())
                .name(sensor.getName())
                .model(sensor.getModel())
                .rangeFrom(sensor.getRangeFrom())
                .rangeTo(sensor.getRangeTo())
                .type(type)
                .unit(unit)
                .location(sensor.getLocation())
                .description(sensor.getDescription())
                .build();
        return sensorRepository.save(sensorFromDb);
    }

    @Override
    public void delete(Long id) {
        sensorRepository.deleteById(id);
    }

    private void validateTypeAndUnit(Sensor sensor, Type type, Unit unit) {
        if (!type.getName().equals(sensor.getType().getName())) {
            throw new IllegalArgumentException("Type name mismatch");
        }
        if (!unit.getName().equals(sensor.getUnit().getName())) {
            throw new IllegalArgumentException("Unit name mismatch");
        }
    }

}
