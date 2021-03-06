package com.rivigo.impl;

import com.rivigo.dto.RequestDto;
import com.rivigo.model.mysql.Request;
import com.rivigo.repository.RequestRepository;
import com.rivigo.service.RequestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class RequestServiceImpl implements RequestService {

    @Autowired
    private RequestRepository requestRepository;



    @Override
    public Long save(RequestDto requestDto){
    Request request=  Request.builder()
                .sourceId(requestDto.getSource())
                .destinationId(requestDto.getDestination())
                .dateOfPacakage(requestDto.getDateOfPickUp())
                .weight(requestDto.getWeight())
                .userId(requestDto.getUser_id()).build();
        try {
           Request request1 = requestRepository.save(request);
           return request1.getId();
        }catch (Exception exception){
            log.info("unable to save request {}",request);
            return null;
        }

    }

}
