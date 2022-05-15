package com.ghapi.greenhouseapi.projection;

import java.time.LocalDateTime;

public interface TemperatureDataProjection {

    Float getTemperature();
    LocalDateTime getTimestamp();

}
