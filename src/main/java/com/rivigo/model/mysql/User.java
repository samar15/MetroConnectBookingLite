package com.rivigo.model.mysql;

import lombok.*;

import javax.persistence.*;
@Table(name = "User")
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name= "full_name")
    private String fullName;

    @Column(name = "contact_no" , unique = true)
    private String contactNo;


}
