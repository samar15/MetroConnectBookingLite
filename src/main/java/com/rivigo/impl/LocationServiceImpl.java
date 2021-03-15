package com.rivigo.impl;

import com.rivigo.Enums.Location;
import com.rivigo.model.mysql.location;
import com.rivigo.repository.LocationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class LocationServiceImpl implements com.rivigo.service.LocationService{

    @Autowired
    LocationRepository locationRepository;

    /*
 distance calculation using haversine formula
 */
    @Override
    public double distance(double origin_lat,double origin_long , double destination_lat, double destination_long){
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
    public double findDistance(Location origin, Location destination) {
        if (null == origin || null == destination) {
            log.info("origin or destination is null");
            return 0d;
        }
        location locations = locationRepository.getByCode(origin);
        /*location originLatLong=locations.stream().filter(location->origin.equals(location.getCode())).collect(Collectors.toList()).get(0);
        location destinationLatLong=locations.stream().filter(location -> destination.equals(location.getCode())).collect(Collectors.toList()).get(0);
        return this.distance(
                originLatLong.getLatitude(),originLatLong.getLongitude(),
                destinationLatLong.getLatitude(),destinationLatLong.getLongitude());


         */
        return 0d;
    }

}
