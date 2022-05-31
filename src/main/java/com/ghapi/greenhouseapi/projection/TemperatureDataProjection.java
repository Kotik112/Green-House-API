package com.ghapi.greenhouseapi.model;

import java.time.LocalDateTime;

public interface TemperatureDataProjection {

    Float getTemperature();
    LocalDateTime getTimestamp();

}
