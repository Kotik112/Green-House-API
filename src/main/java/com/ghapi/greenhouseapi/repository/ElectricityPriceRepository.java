package com.ghapi.greenhouseapi.repository;

import com.ghapi.greenhouseapi.entity.ElectricityPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Repository
public interface ElectricityPriceRepository extends JpaRepository<ElectricityPrice, Long> {

    @Query(
            value = "select * from electricity_price order by timestamp DESC limit 1",
            nativeQuery = true
    )
    ElectricityPrice findLastPrice();



}
