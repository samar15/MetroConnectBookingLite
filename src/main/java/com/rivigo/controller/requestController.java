package com.rivigo.controller;

import com.rivigo.dto.RequestDto;
import com.rivigo.service.LocationService;
import com.rivigo.service.RequestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.rivigo.constants.constants.RATE_PER_KM;

@Slf4j
@RestController
@RequestMapping("/request")
public class requestController {

    @Autowired
    RequestService requestService;

    @Autowired
    LocationService locationService;


    @PostMapping(value= "/saveRequest")
    public Integer saveRequest(@RequestBody RequestDto request){
        try {
            return requestService.create(request);
        }catch (Exception e){
            log.info("exception {}", e.toString());
            return null;
        }

    }

    @GetMapping(value = "/distance")
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
