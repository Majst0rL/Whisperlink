package com.whisperlink.whisperlink.dao;

import com.whisperlink.whisperlink.models.TimePlanner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimePlannerRepository extends CrudRepository<TimePlanner, Long> {

    // Custom query to retrieve TimePlanner events by location
    @Query("SELECT t FROM TimePlanner t WHERE t.location = ?1")
    List<TimePlanner> findByLocation(String location);

    // Custom query to retrieve TimePlanner events happening in the future
    @Query("SELECT t FROM TimePlanner t WHERE t.dateTime > CURRENT_TIMESTAMP")
    List<TimePlanner> findByDateTimeAfterNow();

    // Custom query to retrieve TimePlanner events by name
    @Query("SELECT t FROM TimePlanner t WHERE t.name = ?1")
    List<TimePlanner> findByName(String name);

    // Custom query to retrieve TimePlanner events by location and name
    @Query("SELECT t FROM TimePlanner t WHERE t.location = ?1 AND t.name = ?2")
    List<TimePlanner> findByLocationAndName(String location, String name);

    // Additional custom queries or operations based on your needs
}
