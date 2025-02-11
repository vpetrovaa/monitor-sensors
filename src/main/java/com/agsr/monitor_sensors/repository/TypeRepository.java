package com.agsr.monitor_sensors.repository;

import com.agsr.monitor_sensors.domain.monitor.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository extends JpaRepository<Type, Long> {

}
