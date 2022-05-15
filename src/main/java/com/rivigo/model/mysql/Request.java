package com.rivigo.model.mysql;

import com.rivigo.Enums.RequestStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.GenerationType;

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
    private Float weight;

    @Column(name = "request_status")
    private RequestStatus requestStatus;

}
