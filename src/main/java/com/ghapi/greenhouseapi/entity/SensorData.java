package com.ghapi.greenhouseapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

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
    @GeneratedValue
    @Column(name = "timestamp")
    private LocalDateTime timestamp;
    private Float temperature;
    private Float humidity;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private Department department;

}
