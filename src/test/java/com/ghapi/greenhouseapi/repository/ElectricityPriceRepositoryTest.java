package com.ghapi.greenhouseapi.repository;

import com.ghapi.greenhouseapi.entity.ElectricityPrice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ElectricityPriceRepositoryTest {

    @Autowired
    private ElectricityPriceRepository priceRepository;

    @Test
    public void printLatestPrices() {
        ElectricityPrice price = priceRepository.findLatestPrice();
        System.out.println("Price = "+ price);
    }

    @Test
    public void findAllPrices() {
        List<ElectricityPrice> electricityPrices =
                priceRepository.findAll();
        System.out.println("Price list = " + electricityPrices);
    }

}