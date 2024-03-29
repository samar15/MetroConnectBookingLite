package com.rivigo.impl;

import com.rivigo.model.mysql.Location;
import com.rivigo.repository.LocationRepository;
import com.sun.istack.internal.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static com.rivigo.constants.constants.RATE_PER_KM;

@Service
@Slf4j
class LocationServiceImpl implements com.rivigo.service.LocationService{

    @Autowired
    LocationRepository locationRepository;

    /*
 distance calculation using haversine formula
 */

    private Double distance(Double origin_lat,Double origin_long , Double destination_lat, Double destination_long) throws Exception{
        if(Objects.isNull(origin_lat) || Objects.isNull(origin_long) ||Objects.isNull(destination_lat) || Objects.isNull(destination_long)){
            log.error("origin_lat: {} , origin_long: {} , destination_lat: {} , destination_long : {} is null ", origin_lat, origin_long, destination_lat, destination_long);
            throw new Exception("lat/long of origin/destination is null");
        }
        long radius=6371L ;
        double dlat= Math.toRadians(destination_lat-origin_lat);
        double dlong=Math.toRadians(destination_long-origin_long);
        double a = Math.sin(dlat/2)*Math.sin(dlat/2) +
                Math.cos(Math.toRadians(origin_lat)) * Math.cos(Math.toRadians(destination_lat))*
                        Math.sin(dlong/2)*Math.sin(dlong/2);
        double c =2*Math.atan2(Math.sqrt(a),Math.sqrt(1-a));
        double distance = radius*c;

        return distance;

    }

    @Override
    public Double getDistance(String origin, String destination) throws Exception {
        if (Objects.isNull(origin) || Objects.isNull(destination)) {
            throw new Exception("Origin or destination can't be null");
        }
        List<Location> locations = locationRepository.getAllByCodeIn(Arrays.asList(origin,destination));
        Location originLocation=locations.stream().filter(location->origin.equals(location.getCode())).findAny().orElseThrow( () -> new Exception("Service not allowed"));
        Location destinationLocation=locations.stream().filter(location -> destination.equals(location.getCode())).findAny().orElseThrow(()-> new Exception("Service not allowed"));
        return this.distance(
                originLocation.getLatitude(),originLocation.getLongitude(),
                destinationLocation.getLatitude(),destinationLocation.getLongitude());
    }

    public Double getCost(@NotNull Double distance){
        return distance * RATE_PER_KM;
    }

}
