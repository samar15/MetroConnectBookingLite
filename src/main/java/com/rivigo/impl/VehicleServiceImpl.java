package com.rivigo.impl;

import com.rivigo.model.mysql.Vehicle;
import com.rivigo.repository.VehicleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class VehicleServiceImpl implements com.rivigo.service.VehicleService {

    @Autowired
    VehicleRepository vehicleRepository;

    @Override
   public List<Vehicle> fetchAvailableVehicleList(){
        return vehicleRepository.findAllByIsAvailable(Boolean.TRUE);
    }

    @Override
    public List<Vehicle> findAvailableVehicleByLocation(String location){
        return vehicleRepository.findAllByIsAvailableAndCurrentLocation(Boolean.TRUE,location);
    }
}
