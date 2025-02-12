package com.agsr.monitor_sensors.web.dto.monitor;

import com.agsr.monitor_sensors.web.validator.ValidRange;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@ValidRange
public class SensorDto {

    private Long id;

    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 30, message = "Name should be between 3 and 30 characters")
    private String name;

    @NotBlank(message = "Model is required")
    @Size(max = 15, message = "Model should not more than 15 characters")
    private String model;

    @NotNull(message = "Range from is required")
    @Min(value = 1, message = "Range from should be a positive integer")
    private Integer rangeFrom;

    @NotNull(message = "Range to is required")
    @Min(value = 1, message = "Range to should be a positive integer")
    private Integer rangeTo;

    @NotNull(message = "Type is required")
    private TypeDto type;

    @NotNull(message = "Unit is required")
    private UnitDto unit;

    @Size(max = 40, message = "Location should not more than 40 characters")
    private String location;

    @Size(max = 200, message = "Description should not more than 200 characters")
    private String description;

}
