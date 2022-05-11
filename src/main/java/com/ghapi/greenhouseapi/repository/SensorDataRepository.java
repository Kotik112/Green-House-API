package com.ghapi.greenhouseapi.repository;

import com.ghapi.greenhouseapi.entity.SensorData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SensorDataRepository extends JpaRepository<SensorData, Long> {
    @Query(
            value = "SELECT * FROM sensor_data WHERE department = ?1",
            nativeQuery = true
    )
    List<SensorData> findSensorDataFromDepartmentA(String department);


    @Query(
            value = "SELECT * FROM sensor_data",
            nativeQuery = true
    )
    List<SensorData> findAllTest();
}
