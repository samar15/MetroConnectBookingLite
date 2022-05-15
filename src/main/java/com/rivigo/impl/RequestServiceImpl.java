package com.rivigo.impl;

import com.rivigo.Enums.RequestStatus;
import com.rivigo.dto.RequestDto;
import com.rivigo.dto.RequestInfoDto;
import com.rivigo.model.mysql.Request;
import com.rivigo.model.mysql.Vehicle;
import com.rivigo.repository.RequestRepository;
import com.rivigo.service.LocationService;
import com.rivigo.service.RequestService;
import com.rivigo.service.VehicleService;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
public class RequestServiceImpl implements RequestService {

    @Autowired
    private RequestRepository requestRepository;

    @Autowired
    private LocationService locationService;

    @Autowired
    private VehicleService vehicleService;



    @Override
    public Request validateAndCreateRequest(RequestDto requestDto) throws Exception {
    validateRequest(requestDto);
    Request request =  requestFactory(requestDto.getSource(),
            requestDto.getDestination(),
            requestDto.getDateOfPickUp().getMillis(),
            requestDto.getUser_id(),
            requestDto.getWeight(),
            RequestStatus.CANCELLED);

        try {
            log.info("request: {}",request);
            return requestRepository.save(request);
        }catch (Exception exception){
            log.info("unable to save request {}",exception);
            return null;
        }
    }

    @Override
    public RequestInfoDto makeRequest(RequestDto requestDto) throws Exception {
        validateAndCreateRequest(requestDto);
        Double distance =  locationService.getDistance(requestDto.getSource(),requestDto.getDestination());
        Double cost = locationService.getCost(distance);
        Optional<Vehicle> vehicle = vehicleService.findAvailableVehicleByLocation(requestDto.getSource()).stream().findFirst();
        String vehicleNumber = null;
        if(vehicle.isPresent()){
             vehicleNumber = vehicle.get().getVehicleNumber();
        }
        return RequestInfoDto.builder()
                .distance(distance)
                .cost(cost)
                .availableVehicle(vehicleNumber).build();
    }

    private Request requestFactory(String origin, String destination, Long dateOfPacking, Integer userId, Float weight, RequestStatus requestStatus){
        Request request=  Request.builder()
                .sourceId(origin)
                .destinationId(destination)
                .dateOfPacakage(dateOfPacking)
                .userId(userId)
                .weight(weight)
                .requestStatus(requestStatus).build();

        return request;
    }

    private void validateRequest(RequestDto requestDto) throws Exception{
        if(Objects.isNull(requestDto)){
            throw new Exception("Request can't be null");
        }
        if(Objects.isNull(requestDto.getSource())){
            throw new Exception("Source location can't be null");
        }
        if(Objects.isNull(requestDto.getDestination())){
            throw new Exception("Destination location can't be null");
        }
        if(Objects.isNull(requestDto.getDestination())){
            throw new Exception("Destination location can't be null");
        }
        if(Objects.isNull(requestDto.getUser_id())){
            throw new Exception("user can't be null");
        }
        if(Objects.isNull(requestDto.getDateOfPickUp()) || requestDto.getDateOfPickUp().isBefore(DateTime.now().getMillis())){
            throw new Exception("Pickup date and time can not be of past ");
        }
    }

}
