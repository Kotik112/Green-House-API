/**
 * TODO:    # Index should be in static folder but doesnt work?
 *          # Fix Department Column in all tables to show proper department.
 */

package com.ghapi.greenhouseapi.controller;

import com.ghapi.greenhouseapi.entity.ElectricityPrice;
import com.ghapi.greenhouseapi.entity.SensorData;
import com.ghapi.greenhouseapi.repository.ElectricityPriceRepository;
import com.ghapi.greenhouseapi.repository.SensorDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Controller
public class IndexController {

    @Autowired
    private ElectricityPriceRepository priceRepository;
    @Autowired
    private SensorDataRepository sensorDataRepository;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/humidityNow")
    public String humidityNow(Model model) {
        SensorData sensorData = sensorDataRepository.findLastSensorData();
        model.addAttribute("humidity", sensorData.getHumidity());
        model.addAttribute("datetime", sensorData.getTimestamp());
        model.addAttribute("department", sensorData.getDepartment().getDepartment());
        return "humidityNow";
        //<td>Department</td>
    }
    @GetMapping("/temperatureNow")
    public String temperatureNow(Model model) {
        SensorData sensorData = sensorDataRepository.findLastSensorData();
        model.addAttribute("temperature", sensorData.getTemperature());
        model.addAttribute("datetime", sensorData.getTimestamp());
        model.addAttribute("department", sensorData.getDepartment().getDepartment());
        return "temperatureNow";
    }

    @GetMapping("/priceNow")
    public String electricityPriceNow(Model model) {
        ElectricityPrice electricityPrice = priceRepository.findLastPrice();
        model.addAttribute("price_id", electricityPrice.getPriceId());
        model.addAttribute("price", electricityPrice.getPrice());
        model.addAttribute("timestamp", electricityPrice.getTimestamp());
        return "priceNow";
    }

    @GetMapping("/allSensorData")
    public String allSensorData(Model model) {
        SensorData sensorData = sensorDataRepository.findLastSensorData();
        ElectricityPrice electricityPrice = priceRepository.findLastPrice();
        model.addAttribute("temperature", sensorData.getTemperature());
        model.addAttribute("humidity", sensorData.getHumidity());
        model.addAttribute("price", electricityPrice.getPrice());
        model.addAttribute("department", sensorData.getDepartment().getDepartment());
        return "allSensorData";
    }

    @GetMapping("/form")
    private String priceForm() {
        return "inputPrice";
    }

    @PostMapping("/inputPrice")
    public String inputPrice(@RequestParam Float price, Model model) {
        ElectricityPrice ep = new ElectricityPrice();
        ep.setPrice(price);
        ep.setTimestamp(LocalDateTime.now());
        priceRepository.save(ep);
        return "allSensorData";
    }

    //@GetMapping(/)
}
