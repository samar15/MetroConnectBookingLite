package com.rivigo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import com.rivigo.Enums.Location;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.joda.time.DateTime;

import java.sql.Timestamp;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestDto {
    @NotNull
    String source;

    @NotNull
    String destination;

    @NotNull
    float weight;


    String dateOfPickUp;

    @NotNull
    Long user_id;

}
