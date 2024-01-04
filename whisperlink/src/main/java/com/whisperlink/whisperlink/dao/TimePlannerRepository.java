package com.whisperlink.whisperlink.dao;

import com.whisperlink.whisperlink.models.Location;
import com.whisperlink.whisperlink.models.TimePlanner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface TimePlannerRepository extends CrudRepository<TimePlanner, Long> {


    // Complex query with 2 parameters
    @Query("SELECT t FROM TimePlanner t WHERE t.location = :location AND t.name = :name")
    List<TimePlanner> findByLocationAndName(@Param("location") String location, @Param("name") String name);

    //  complex query with 2 parameters (start and end date)
    @Query("SELECT t FROM TimePlanner t WHERE t.date BETWEEN :startDate AND :endDate")
    List<TimePlanner> findByDateBetween(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    //  complex query with 3 parameters
    @Query("SELECT t FROM TimePlanner t WHERE t.location = :location AND t.date BETWEEN :startDate AND :endDate")
    List<TimePlanner> findByLocationAndDateBetween(
            @Param("location") Location location,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate
    );

    @Query("SELECT t FROM TimePlanner t WHERE t.name = :name AND t.date BETWEEN :startDate AND :endDate")
    List<TimePlanner> findByNameAndDateBetween(
            @Param("name") String name,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate
    );
    @Query("SELECT t FROM TimePlanner t JOIN t.location l JOIN t.date d WHERE l.address = :name AND d.year = :year")
    List<TimePlanner> findByLocationNameAndDateYear(
            @Param("name") String name,
            @Param("year") int year
    );


}
