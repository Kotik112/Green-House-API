package com.ghapi.greenhouseapi.repository;

import com.ghapi.greenhouseapi.entity.SensorData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface SensorDataRepository extends JpaRepository<SensorData, LocalDateTime> {
    //Functions to grab data from db
}
