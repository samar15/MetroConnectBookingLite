package com.rivigo.model.mysql;

import com.rivigo.Enums.Location;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class location  {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "code")
    private Location code;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;
}
