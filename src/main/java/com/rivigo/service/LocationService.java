package com.rivigo.service;

import com.rivigo.Enums.Location;


public interface LocationService {
    Double findDistance(String origin , String distance);

    Double distance(Double origin_lat, Double origin_long ,
                    Double destination_lat, Double destination_long);
}
