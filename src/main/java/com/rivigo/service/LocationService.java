package com.rivigo.service;


public interface LocationService {
    Double getDistance(String origin , String distance) throws Exception;

    Double getCost(Double distance);

}
