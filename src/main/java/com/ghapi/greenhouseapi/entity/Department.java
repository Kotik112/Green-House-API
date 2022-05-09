package com.ghapi.greenhouseapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {
    @Id
    @GeneratedValue
    private Integer departmentId;
    private String department;

    @OneToOne(
            mappedBy = "department"
    )
    private SensorData sensorData;

}
