package com.agsr.monitor_sensors.domain.exception;

public class ResourceDoesNotExistException extends RuntimeException {

    public ResourceDoesNotExistException(String message) {
        super(message);
    }

}
