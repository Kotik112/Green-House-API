package com.ghapi.greenhouseapi.projection;

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
