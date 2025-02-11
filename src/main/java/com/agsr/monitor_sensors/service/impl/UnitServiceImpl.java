package com.agsr.monitor_sensors.service.impl;

import com.agsr.monitor_sensors.domain.exception.ResourceDoesNotExistException;
import com.agsr.monitor_sensors.domain.monitor.Unit;
import com.agsr.monitor_sensors.repository.UnitRepository;
import com.agsr.monitor_sensors.service.UnitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UnitServiceImpl implements UnitService {

    private final UnitRepository unitRepository;

    @Override
    public Unit findById(Long id) {
        return unitRepository.findById(id)
                .orElseThrow(() -> new ResourceDoesNotExistException(
                        "Unit with id " + id + " does not exist"
                ));
    }

}
