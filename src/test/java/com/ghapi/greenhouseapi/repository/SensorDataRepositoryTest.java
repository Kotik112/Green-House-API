package com.ghapi.greenhouseapi.repository;

import com.ghapi.greenhouseapi.entity.Department;
import com.ghapi.greenhouseapi.entity.SensorData;
import com.ghapi.greenhouseapi.repository.SensorDataRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;


@SpringBootTest
class SensorDataRepositoryTest {

    @Autowired
    private SensorDataRepository sensorDataRepository;

    @Test
    public void saveSensorData() {
        Department department = Department.builder()
                .department("A")
                .build();
        SensorData sensorData = SensorData.builder()
                .timestamp(LocalDateTime.now())
                .temperature((float) 23.14)
                .humidity((float) 44.03)
                .department(department)
                .build();
        sensorDataRepository.save(sensorData);
        System.out.println(sensorData);
    }

    @Test
    public void displaySensorData() {
        List<SensorData> sensorData = sensorDataRepository.findAll();
        System.out.println("Sensor Data = " + sensorData);
    }
}
