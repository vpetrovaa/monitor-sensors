package com.agsr.monitor_sensors.service.impl;

import com.agsr.monitor_sensors.domain.exception.ResourceDoesNotExistException;
import com.agsr.monitor_sensors.domain.monitor.Type;
import com.agsr.monitor_sensors.repository.TypeRepository;
import com.agsr.monitor_sensors.service.TypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TypeServiceImpl implements TypeService {

    private final TypeRepository typeRepository;

    @Override
    public Type findById(Long id) {
        return typeRepository.findById(id)
                .orElseThrow(() -> new ResourceDoesNotExistException(
                        "Type with id " + id + " does not exist"
                ));
    }

}
