package com.ghapi.greenhouseapi.repository;

import com.ghapi.greenhouseapi.entity.Department;
import com.ghapi.greenhouseapi.entity.SensorData;
import com.ghapi.greenhouseapi.model.AverageHumidityDTO;
import com.ghapi.greenhouseapi.model.AverageTemperatureDTO;
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
                .temperature((float) 27.14)
                .humidity((float) 34.03)
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

    @Test
    public void printLastSensorData() {
        SensorData sensorData = sensorDataRepository.findLastSensorData();
        System.out.println("Sensor Data = " + sensorData);
    }

    @Test
    public void printAverageTemp() {
        List<AverageTemperatureDTO> averageTemperatureList = sensorDataRepository.averageTemperature(1L);
        System.out.println("Sensor Data 1 = " + averageTemperatureList);
    }

    @Test
    public void printAverageHumidity() {
        List<AverageHumidityDTO>  averageHumidityList = sensorDataRepository.averageHumidity(1L);
        System.out.println("Sensor Data 1 = " + averageHumidityList);
    }
}
