package com.rivigo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.joda.time.DateTime;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestDto {
    @NotNull
    private String source;

    @NotNull
    private String destination;

    @NotNull
    private float weight;

    @NotNull
    private DateTime dateOfPickUp;

    @NotNull
    private Integer user_id;

}
