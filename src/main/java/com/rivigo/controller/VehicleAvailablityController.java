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
    
    @RequestMapping(value = "/available_vehicles", method = RequestMethod.GET)
    public List<Vehicle> fetchAvailableVehicleList(){
        return vehicleService.fetchAvailableVehicleList();

    }

    @RequestMapping(value= "/saveRequest", method = RequestMethod.POST)
    public Long saveRequest(@RequestBody RequestDto request){
        try {
            return requestService.save(request);
        }catch (Exception e){
            log.info("exception {}", e.toString());
            return null;
        }

    }

    @RequestMapping(value = "/distance", method = RequestMethod.GET)
    public Double findCost(@RequestParam String origin,
                           @RequestParam String destination){
        try{
            return locationService.findDistance(origin,destination);
        }catch (Exception e){
            log.info("error {}" ,e.toString());
            return null;
        }
    }

}
