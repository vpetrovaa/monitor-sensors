package com.agsr.monitor_sensors.repository;

import com.agsr.monitor_sensors.domain.monitor.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorRepository extends JpaRepository<Sensor, Long> {

}
