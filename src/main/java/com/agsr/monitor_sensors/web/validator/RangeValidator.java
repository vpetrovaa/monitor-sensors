package com.agsr.monitor_sensors.web.validator;

import com.agsr.monitor_sensors.web.dto.monitor.SensorDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RangeValidator implements ConstraintValidator<ValidRange, SensorDto> {

    @Override
    public boolean isValid(SensorDto sensorDto, ConstraintValidatorContext context) {
        if (sensorDto.getRangeFrom() == null || sensorDto.getRangeTo() == null) {
            return true;
        }
        return sensorDto.getRangeFrom() < sensorDto.getRangeTo();
    }

}
