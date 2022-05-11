package com.ghapi.greenhouseapi.repository;

import com.ghapi.greenhouseapi.entity.Department;
import com.ghapi.greenhouseapi.entity.SensorData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SensorDataRepositoryTest {

    @Autowired
    private SensorDataRepository sensorDataRepository;

    @Test
    public void saveSensorData() {
        Department department = Department.builder()
                .departmentId(1)
                .build();
        SensorData sensorData = SensorData.builder()
                .temperature((float) 33.41)
                .humidity((float) 63.44)
                .department(department)
                .build();
        System.out.println(sensorData);
    }


}