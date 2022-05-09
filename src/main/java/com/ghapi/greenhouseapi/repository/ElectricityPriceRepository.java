package com.ghapi.greenhouseapi.repository;

import com.ghapi.greenhouseapi.entity.ElectricityPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface ElectricityPriceRepository extends JpaRepository<ElectricityPrice, LocalDateTime> {

    @Query(
            value = "select * from electricity_price order by timestamp DESC limit 1",
            nativeQuery = true
    )
    ElectricityPrice findLatestPrice();

}
