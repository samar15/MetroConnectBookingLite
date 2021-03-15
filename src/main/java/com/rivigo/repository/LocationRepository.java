package com.rivigo.repository;

import com.rivigo.Enums.Location;
import com.rivigo.model.mysql.location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LocationRepository extends JpaRepository<location,Long> {
    location getByCode(Location location );
}