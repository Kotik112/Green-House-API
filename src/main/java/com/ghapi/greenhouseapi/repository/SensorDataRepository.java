package com.ghapi.greenhouseapi.repository;

import com.ghapi.greenhouseapi.entity.SensorData;
import com.ghapi.greenhouseapi.projection.AverageHumidityDTO;
import com.ghapi.greenhouseapi.projection.AverageTemperatureDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SensorDataRepository extends JpaRepository<SensorData, Long> {
    @Query(
            value = "SELECT * FROM sensor_data ORDER BY timestamp DESC LIMIT 1",
            nativeQuery = true
    )
    SensorData findLastSensorData();

   @Query(
            value = "SELECT AVG(temperature) AS averagetemperature," +
                    "       DATE(timestamp) AS date" +
                    "FROM sensor_data" +
                    "WHERE department_id = 1" +
                    "GROUP BY DATE(timestamp)",
            nativeQuery = true
    )
    List<AverageTemperatureDTO> averageTemperature(Long departmentId);

    @Query(
            value = "SELECT AVG(humidity) AS averagehumidity," +
                    "       DATE(timestamp) AS date" +
                    "FROM sensor_data" +
                    "WHERE department_id = 1" +
                    "GROUP BY DATE(timestamp)",
            nativeQuery = true
    )
    List<AverageHumidityDTO> averageHumidity(Long departmentId);

    /* this function gives you average humidity and temperature of each department on each day .. rounding of the value till 3 decimal places
  for getting values according to each department and day  we have group by the department id and timestamp */
    @Query(value = "select round((dc.humidity),3) as humidity,dc.department_id,dc.timestamp from db_uppg.sensor_data dc group by department_id,dc.timestamp",nativeQuery = true)
    List<AverageHumidityDTO> findHumidity();

    @Query(value = "select round((dc.temperature),3) as temperature ,dc.department_id,dc.timestamp from db_uppg.sensor_data dc group by department_id,dc.timestamp",nativeQuery = true)
    List<Object[]> findTemperature();
}