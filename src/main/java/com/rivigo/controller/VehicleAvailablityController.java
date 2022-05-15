package com.rivigo.controller;

import com.rivigo.Enums.Location;
import com.rivigo.dto.RequestDto;
import com.rivigo.model.mysql.Vehicle;
import com.rivigo.service.LocationService;
import com.rivigo.service.RequestService;
import com.rivigo.service.VehicleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.rivigo.constants.constants.RATE_PER_KM;

@RestController
@Slf4j
@RequestMapping(value = {"/vehicle"})
public class VehicleAvailablityController {

    @Autowired
    VehicleService vehicleService;

    @Autowired
    RequestService requestService;

    @Autowired
    LocationService locationService;
    
    @GetMapping(value = "/available_vehicles")
    public List<Vehicle> fetchAvailableVehicleList(){
        return vehicleService.fetchAvailableVehicleList();

    }

    @PostMapping(value= "/saveRequest")
    public Integer saveRequest(@RequestBody RequestDto request){
        try {
            return requestService.create(request);
        }catch (Exception e){
            log.info("exception {}", e.toString());
            return null;
        }

    }

    @GetMapping (value = "/distance")
    public Double findDistance(@RequestParam String origin,
                           @RequestParam String destination){
        try{
            return locationService.findDistance(origin,destination);
        }catch (Exception e){
            log.error("error {}" ,e.toString());
            return null;
        }
    }

    @GetMapping (value = "/cost")
    public Double getCost(@RequestParam String origin,
                          @RequestParam String destination){
        try{
            Double distance=locationService.findDistance(origin,destination);
            return distance * RATE_PER_KM;
        }catch ( Exception e){
            log.error("error {}", e.toString());
            return null;
        }
    }

}
