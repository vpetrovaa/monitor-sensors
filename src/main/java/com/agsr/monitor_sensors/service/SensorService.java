package com.agsr.monitor_sensors.service;

import com.agsr.monitor_sensors.domain.monitor.Sensor;

import java.util.List;

public interface SensorService {

    Sensor create(Sensor sensor);

    Sensor findById(Long id);

    List<Sensor> findAll();

    Sensor update(Long id, Sensor sensor);

    void delete(Long id);

}
