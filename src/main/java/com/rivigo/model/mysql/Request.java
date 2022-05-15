package com.rivigo.model.mysql;


import com.rivigo.Enums.Location;
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
    private Integer id;

    @Column(name = "source_code")
    private String sourceId;

    @Column(name = "destination_code")
    private String destinationId;

    @Column(name = "date_of_package")
    private Long dateOfPacakage;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "weight")
    private float weight;

}
