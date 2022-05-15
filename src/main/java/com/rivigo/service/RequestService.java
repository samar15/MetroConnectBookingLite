package com.rivigo.service;

import com.rivigo.dto.RequestDto;
import com.rivigo.dto.RequestInfoDto;
import com.rivigo.model.mysql.Request;


public interface RequestService {
    Request validateAndCreateRequest(RequestDto requestDto) throws Exception;

    RequestInfoDto makeRequest(RequestDto requestDto)throws Exception;





}
