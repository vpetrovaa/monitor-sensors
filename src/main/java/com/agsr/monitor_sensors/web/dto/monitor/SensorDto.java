package com.agsr.monitor_sensors.web.dto.monitor;

import com.agsr.monitor_sensors.web.validator.ValidRange;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@ValidRange
@Schema(description = "Information about sensor")
public class SensorDto {

    @Schema(description = "The unique identifier of the sensor",
            example = "1", required = true)
    private Long id;

    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 30, message = "Name should be between 3 and 30 characters")
    @Schema(description = "The name of the sensor (3 to 30 characters)",
            example = "Thermometer", required = true)
    private String name;

    @NotBlank(message = "Model is required")
    @Size(max = 15, message = "Model should not more than 15 characters")
    @Schema(description = "The model of the sensor (up to 15 characters)",
            example = "T-100", required = true)
    private String model;

    @NotNull(message = "Range from is required")
    @Min(value = 1, message = "Range from should be a positive integer")
    @Schema(description = "Range from (positive integer)",
            example = "5", required = true)
    private Integer rangeFrom;

    @NotNull(message = "Range to is required")
    @Min(value = 1, message = "Range to should be a positive integer")
    @Schema(description = "Range to (positive integer, less than range from)",
            example = "40", required = true)
    private Integer rangeTo;

    @NotNull(message = "Type is required")
    @Schema(description = "The type of the sensor", required = true)
    private TypeDto type;

    @NotNull(message = "Unit is required")
    @Schema(description = "The unit of measurement for the sensor", required = true)
    private UnitDto unit;

    @Size(max = 40, message = "Location should not more than 40 characters")
    @Schema(description = "Location of the sensor", example = "Living Room", maxLength = 40)
    private String location;

    @Size(max = 200, message = "Description should not more than 200 characters")
    @Schema(description = "A description of the sensor",
            example = "Measures temperature in the living room",
            maxLength = 200)
    private String description;

}
