package com.ghapi.greenhouseapi.repository;

import com.ghapi.greenhouseapi.entity.SensorData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface SensorDataRepository extends JpaRepository<SensorData, LocalDateTime> {
    @Query("SELECT * FROM sensor_data WHERE department = ?1")
    SensorData findSensorDataFromDepartmentA(String department);
}
