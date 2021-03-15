package com.rivigo.model.mysql;

import com.rivigo.Enums.Status;
import com.rivigo.Enums.Location;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Trips {

    @Id
    private Long id;

    @Column(name = "from_location")
    private Location fromLocation;

    @Column(name = "to_location")
    private Location toLocation;

    @Column(name = "vehicle_number")
    private String vehicleNumber;

    @Column(name = "date_of_trip")
    private Date dateOfTrip;

    @Column(name = "status")
    private Status status;

    @Column(name = "request_id")
    private Long requestId;

}
