package com.rivigo.controller;

import com.rivigo.dto.RequestDto;
import com.rivigo.dto.RequestInfoDto;
import com.rivigo.model.mysql.Vehicle;
import com.rivigo.service.LocationService;
import com.rivigo.service.RequestService;
import com.rivigo.service.VehicleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@Slf4j
@RestController
@RequestMapping("/request")
public class RequestController {

    @Autowired
    RequestService requestService;

    @Autowired
    LocationService locationService;


    @PostMapping(value= "/make_request")
    public RequestInfoDto saveRequest(@RequestBody RequestDto request){
        try {
            return requestService.makeRequest(request);
        }catch (Exception e){
            log.info("exception {}", e.toString());
            return null;
        }

    }

    @GetMapping(value = "/distance")
    public Double findDistance(@RequestParam String origin,
                               @RequestParam String destination){
        try{
            return locationService.getDistance(origin,destination);
        }catch (Exception e){
            log.error("error {}" ,e.toString());
            return null;
        }
    }

    @GetMapping (value = "/cost")
    public Double getCost(@RequestParam String origin,
                          @RequestParam String destination){
        try{
            Double distance=locationService.getDistance(origin,destination);
            return locationService.getCost(distance);
        }catch ( Exception e){
            log.error("error {}", e.toString());
            return null;
        }
    }

}
