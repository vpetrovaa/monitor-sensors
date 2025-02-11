package com.agsr.monitor_sensors.repository;

import com.agsr.monitor_sensors.domain.monitor.Unit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnitRepository extends JpaRepository<Unit, Long> {

}