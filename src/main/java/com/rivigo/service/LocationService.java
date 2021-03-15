package com.rivigo.service;

import com.rivigo.Enums.Location;


public interface LocationService {
    double findDistance(Location origin , Location distance);

    double distance(double origin_lat, double origin_long ,
                    double destination_lat, double destination_long);
}
