package com.whisperlink.whisperlink.dao;

import com.whisperlink.whisperlink.models.TimePlanner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimePlannerRepository extends CrudRepository<TimePlanner, Long> {


    // Custom query to retrieve TimePlanner events by location and name
    @Query("SELECT t FROM TimePlanner t WHERE t.location = ?1 AND t.name = ?2")
    List<TimePlanner> findByLocationAndName(String location, String name);

}
