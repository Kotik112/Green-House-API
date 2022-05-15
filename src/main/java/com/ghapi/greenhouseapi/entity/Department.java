package com.ghapi.greenhouseapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long departmentId;
    @Column(
            name = "department",
            unique = true
    )
    private String department;

    @OneToMany(
            mappedBy = "department",
            fetch = FetchType.LAZY
    )
    private List<SensorData> sensorData;

}
