package com.whisperlink.whisperlink.dao;

import com.whisperlink.whisperlink.models.DateCalendar;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DateCalendarRepository extends CrudRepository<DateCalendar, Long> {

    //Complex querry with 3 parameters
    @Query("SELECT d FROM DateCalendar d WHERE d.year = :year AND d.id = :id and d.month = :month")
    List<DateCalendar> findByYear(@Param("year") int year, @Param("id") Long id, @Param("month") int month);

    // Complex query with 2 parameters
    @Query("SELECT d FROM DateCalendar d WHERE d.month = :month AND d.year = :year")
    List<DateCalendar> findByMonthAndYear(@Param("month") int month, @Param("year") int year);

}
