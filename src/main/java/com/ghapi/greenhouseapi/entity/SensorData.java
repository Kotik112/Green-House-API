package com.ghapi.greenhouseapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(
        name = "sensor_data"
)
public class SensorData {
    @Id
    /*@SequenceGenerator(
            name = "sensor_data_sequence",
            sequenceName = "sensor_data_sequence",
            allocationSize = 1
    )*/
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sensorDataId;

    @Column(
            name = "timestamp",
            insertable = false,
            updatable = false
    )
    private LocalDateTime timestamp;

    @Column(
            name = "temperature"
    )
    private Float temperature;

    @Column(
            name = "humidity"
    )
    private Float humidity;

    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false,
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "department_id",
            nullable = false
    )
    private Department department;

}
