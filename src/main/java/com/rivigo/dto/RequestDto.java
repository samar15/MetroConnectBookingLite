package com.rivigo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import com.rivigo.Enums.locations;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import  org.joda.time.DateTime;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestDto {
    @NotNull
     locations source;

    @NotNull
    locations destination;

    @NotNull
    float weight;

    @NotNull
    DateTime dateOfPickUp;

    @NotNull
    Long user_id;

}
