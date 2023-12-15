package com.whisperlink.whisperlink.controllers;

import com.whisperlink.whisperlink.dao.TimePlannerRepository;
import com.whisperlink.whisperlink.models.TimePlanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/time-planners")
public class TimePlannerController {

    @Autowired
    private TimePlannerRepository timePlannerRepository;

    @GetMapping
    public List<TimePlanner> getAllTimePlanners() {
        return (List<TimePlanner>) timePlannerRepository.findAll();
    }

    @PostMapping
    public void addTimePlanner(@RequestBody TimePlanner timePlanner) {
        timePlannerRepository.save(timePlanner);
    }

    @GetMapping("/{id}")
    public TimePlanner getTimePlannerById(@PathVariable Long id) {
        return timePlannerRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public void updateTimePlanner(@PathVariable Long id, @RequestBody TimePlanner updatedTimePlanner) {
        // Implement logic to update the existing time planner
        // You might want to find the time planner by ID or other criteria and update its properties
        timePlannerRepository.save(updatedTimePlanner);
    }

    @DeleteMapping("/{id}")
    public void removeTimePlanner(@PathVariable Long id) {
        timePlannerRepository.deleteById(id);
    }
}
