package com.rivigo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import com.rivigo.Enums.Location;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestDto {
    @NotNull
    Location source;

    @NotNull
    Location destination;

    @NotNull
    float weight;

    @NotNull
    Timestamp dateOfPickUp;

    @NotNull
    Long user_id;

}
