package com.rivigo.model.mysql;


import com.rivigo.Enums.locations;
import lombok.*;
import org.joda.time.DateTime;

import javax.persistence.*;

@Table(name = "request")
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "source_code")
    private locations sourceId;

    @Column(name = "destination_code")
    private locations destinationId;

    @Column(name = "date_of_package")
    private DateTime dateOfPacakage;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "weight")
    private float weight;

}
