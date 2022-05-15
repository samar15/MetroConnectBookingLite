package com.rivigo.repository;


import com.rivigo.model.mysql.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle,Integer> {
    List<Vehicle>findAllByIsAvailable(Boolean isAvailable);
}
