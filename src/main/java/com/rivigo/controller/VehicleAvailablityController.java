package com.rivigo.controller;

import com.rivigo.model.mysql.Vehicle;
import com.rivigo.service.VehicleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = {"/vehicle"})
public class VehicleAvailablityController {

    @Autowired
    VehicleService vehicleService;

    @GetMapping(value = "/available_vehicles")
    public List<Vehicle> fetchAvailableVehicleList(){
        return vehicleService.fetchAvailableVehicleList();

    }
}
