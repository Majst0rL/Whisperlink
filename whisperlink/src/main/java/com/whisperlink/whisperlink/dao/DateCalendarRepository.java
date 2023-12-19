package com.whisperlink.whisperlink.dao;

import com.whisperlink.whisperlink.models.DateCalendar;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DateCalendarRepository extends CrudRepository<DateCalendar, Long> {

    @Query("SELECT d FROM DateCalendar d WHERE d.year = ?1")
    List<DateCalendar> findByYear(int year);

    // Custom query for retrieving DateCalendars by month and year
    @Query("SELECT d FROM DateCalendar d WHERE d.month = ?1 AND d.year = ?2")
    List<DateCalendar> findByMonthAndYear(int month, int year);

}
