package com.ghapi.greenhouseapi.model;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString
@AllArgsConstructor
public class AverageTemperatureDTO {
    Float temperature;
    LocalDateTime timestamp;

    public Float getTemperature() {
        return temperature;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
