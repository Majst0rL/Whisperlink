package com.whisperlink.whisperlink.controllers;

import com.whisperlink.whisperlink.dao.DateCalendarRepository;
import com.whisperlink.whisperlink.dao.LocationRepository;
import com.whisperlink.whisperlink.models.DateCalendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/date-calendars")
public class DateCalendarController {

    @Autowired
    private DateCalendarRepository dateCalendarRepository;

    @GetMapping
    public List<DateCalendar> getAllDateCalendars() {
        return (List<DateCalendar>) dateCalendarRepository.findAll();
    }

    @PostMapping
    public void addDateCalendar(@RequestBody DateCalendar dateCalendar) {
        dateCalendarRepository.save(dateCalendar);
    }

    @GetMapping("/{id}")
    public DateCalendar getDateCalendarById(@PathVariable Long id) {
        return dateCalendarRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public void updateDateCalendar(@PathVariable Long id, @RequestBody DateCalendar updatedDateCalendar) {
        // Implement logic to update the existing date calendar
        // You might want to find the date calendar by ID or other criteria and update its properties
        dateCalendarRepository.save(updatedDateCalendar);
    }

    @DeleteMapping("/{id}")
    public void removeDateCalendar(@PathVariable Long id) {
        dateCalendarRepository.deleteById(id);
    }
    @GetMapping("gledenaleto/{year}/gledenamesec/{month}")
    public List<DateCalendar> getiDateCalendars(@PathVariable("leto") int year, @PathVariable("month") int month) {
        return (List<DateCalendar>) dateCalendarRepository.findByYear(year, month);
    }

}
