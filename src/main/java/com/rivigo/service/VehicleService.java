package com.rivigo.service;

import com.rivigo.model.mysql.Vehicle;

import java.util.List;

public interface VehicleService {
     List<Vehicle> fetchAvailableVehicleList();

     List<Vehicle> findAvailableVehicleByLocation(String location);
}
