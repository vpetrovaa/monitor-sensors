package com.agsr.monitor_sensors.repository;

import com.agsr.monitor_sensors.domain.monitor.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SensorRepository extends JpaRepository<Sensor, Long> {

    @Query("SELECT s FROM Sensor s WHERE LOWER(s.name) LIKE LOWER(CONCAT('%', :searchText, '%')) " +
                  "OR LOWER(s.model) LIKE LOWER(CONCAT('%', :searchText, '%'))")
    List<Sensor> findByNameOrModel(@Param("searchText") String searchText);

}
