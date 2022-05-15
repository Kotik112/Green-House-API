package com.ghapi.greenhouseapi.projection;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString
@AllArgsConstructor
public class AverageHumidityDTO {

    Float humidity;
    LocalDateTime timestamp;

    public Float getHumidity() {
        return humidity;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
