package com.rivigo.repository;

import com.rivigo.model.mysql.Trips;
import org.springframework.data.jpa.repository.JpaRepository;

 public interface TripsRepository extends JpaRepository<Trips,Long>{}

