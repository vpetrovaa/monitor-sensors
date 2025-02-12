package com.agsr.monitor_sensors.web.controller;

import com.agsr.monitor_sensors.domain.monitor.Sensor;
import com.agsr.monitor_sensors.service.SensorService;
import com.agsr.monitor_sensors.web.dto.ResponseDto;
import com.agsr.monitor_sensors.web.dto.monitor.SensorDto;
import com.agsr.monitor_sensors.web.mapper.SensorMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
@RequestMapping("api/v1/sensors")
@RequiredArgsConstructor
@Tag(name = "MonitorSensor", description = "Controller for managing monitor sensors")
public class MonitorSensorController {

    private final SensorService sensorService;
    private final SensorMapper sensorMapper;

    @PostMapping
    @Operation(summary = "Create a new sensor",
            description = "This endpoint allows you to create a new sensor in the system.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Sensor was created successfully"),
            @ApiResponse(responseCode = "400", description = "Bad request due to invalid input data",
                    content = @Content(schema = @Schema(implementation = ResponseDto.class,
                            example = "{ \"errors\": [\"Invalid data provided\"] }"))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(schema = @Schema(implementation = ResponseDto.class,
                            example = "{ \"errors\": [\"Internal server error occurred\"] }")))
    })
    public SensorDto create(@Valid @RequestBody SensorDto sensorDto) {
        Sensor sensor = sensorMapper.toEntity(sensorDto);
        sensor = sensorService.create(sensor);
        return sensorMapper.toDto(sensor);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get sensor by ID",
            description = "This endpoint retrieves a sensor by its ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sensor is found successfully"),
            @ApiResponse(responseCode = "404", description = "Sensor is not found",
                    content = @Content(schema = @Schema(implementation = ResponseDto.class,
                            example = "{ \"errors\": [\"Sensor is not found\"] }"))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(schema = @Schema(implementation = ResponseDto.class,
                            example = "{ \"errors\": [\"Internal server error occurred\"] }")))
    })
    public SensorDto findById(@PathVariable Long id) {
        Sensor sensor = sensorService.findById(id);
        return sensorMapper.toDto(sensor);
    }

    @GetMapping
    @Operation(summary = "Get all sensors",
            description = "This endpoint retrieves all sensors from the system.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sensors were retrieved successfully"),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(schema = @Schema(implementation = ResponseDto.class,
                            example = "{ \"errors\": [\"Internal server error occurred\"] }")))
    })
    public List<SensorDto> findAll() {
        List<Sensor> sensors = sensorService.findAll();
        return sensorMapper.toDtoList(sensors);
    }

    @GetMapping("/search")
    @Operation(summary = "Search for sensors by name or model",
            description = "This endpoint searches sensors by name or model.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sensors are found successfully"),
            @ApiResponse(responseCode = "400", description = "Bad request due to invalid search input",
                    content = @Content(schema = @Schema(implementation = ResponseDto.class,
                            example = "{ \"errors\": [\"Invalid search text\"] }"))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(schema = @Schema(implementation = ResponseDto.class,
                            example = "{ \"errors\": [\"Internal server error occurred\"] }")))
    })
    public List<SensorDto> findByNameOrModel(@RequestParam String searchText) {
        List<Sensor> sensors = sensorService.findByNameOrModel(searchText);
        return sensorMapper.toDtoList(sensors);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update sensor details",
            description = "This endpoint allows you to update an existing sensor's information.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sensor was updated successfully"),
            @ApiResponse(responseCode = "400", description = "Bad request due to invalid input data",
                    content = @Content(schema = @Schema(implementation = ResponseDto.class,
                            example = "{ \"errors\": [\"Invalid data provided\"] }"))),
            @ApiResponse(responseCode = "404", description = "Sensor is not found",
                    content = @Content(schema = @Schema(implementation = ResponseDto.class,
                            example = "{ \"errors\": [\"Sensor is not found\"] }"))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(schema = @Schema(implementation = ResponseDto.class,
                            example = "{ \"errors\": [\"Internal server error occurred\"] }")))
    })
    public SensorDto update(@PathVariable Long id, @Valid @RequestBody SensorDto sensorDto) {
        Sensor sensor = sensorMapper.toEntity(sensorDto);
        sensor = sensorService.update(id, sensor);
        return sensorMapper.toDto(sensor);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a sensor",
            description = "This endpoint allows you to delete a sensor by its ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Sensor was deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Sensor is not found",
                    content = @Content(schema = @Schema(implementation = ResponseDto.class,
                            example = "{ \"errors\": [\"Sensor is not found\"] }"))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(schema = @Schema(implementation = ResponseDto.class,
                            example = "{ \"errors\": [\"Internal server error occurred\"] }")))
    })
    public void deleteSensor(@PathVariable Long id) {
        sensorService.delete(id);
    }

}
