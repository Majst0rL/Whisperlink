package com.whisperlink.whisperlink.dao;

import com.whisperlink.whisperlink.models.TimePlanner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimePlannerRepository extends CrudRepository<TimePlanner, Long> {


    // Complex query with 2 parameters
    @Query("SELECT t FROM TimePlanner t WHERE t.location = :location AND t.name = :name")
    List<TimePlanner> findByLocationAndName(@Param("location") String location, @Param("name") String name);

}
