package com.rivigo.impl;

import com.rivigo.Enums.Location;
import com.rivigo.model.mysql.location;
import com.rivigo.repository.LocationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
class LocationServiceImpl implements com.rivigo.service.LocationService{

    @Autowired
    LocationRepository locationRepository;

    /*
 distance calculation using haversine formula
 */
    @Override
    public Double distance(Double origin_lat,Double origin_long , Double destination_lat, Double destination_long){
        if(null == origin_lat || null == origin_long || null == destination_lat || null == destination_long   ){
            log.error("origin_lat: {} , origin_long: {} , destination_lat: {} , destination_long : {} is null ", origin_lat, origin_long, destination_lat, destination_long);
            return null;
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
    public Double findDistance(String origin, String destination) {
        if (null == origin || null == destination) {
            log.info("origin or destination is null");
            return 0d;
        }
        List<location> locations = locationRepository.getAllByCodeIn(Arrays.asList(String.valueOf(origin),String.valueOf(destination)));
        location originLatLong=locations.stream().filter(location->origin.equals(location.getCode())).collect(Collectors.toList()).get(0);
        location destinationLatLong=locations.stream().filter(location -> destination.equals(location.getCode())).collect(Collectors.toList()).get(0);
        return this.distance(
                originLatLong.getLatitude(),originLatLong.getLongitude(),
                destinationLatLong.getLatitude(),destinationLatLong.getLongitude());

    }

}
