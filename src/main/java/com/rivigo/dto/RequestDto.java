package com.rivigo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

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

    @NotNull
    Long dateOfPickUp;

    @NotNull
    Integer user_id;

}
