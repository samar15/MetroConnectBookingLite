package com.rivigo.repository;


import com.rivigo.model.mysql.location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface LocationRepository extends JpaRepository<location,Long> {
    List<location> getAllByCodeIn(List<String> location );
}