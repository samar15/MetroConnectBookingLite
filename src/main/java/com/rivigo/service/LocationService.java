package com.rivigo.service;


public interface LocationService {
    Double findDistance(String origin , String distance) throws Exception;

    Double distance(Double origin_lat, Double origin_long ,
                    Double destination_lat, Double destination_long) throws Exception;
}
