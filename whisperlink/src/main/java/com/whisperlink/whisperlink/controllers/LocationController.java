package com.whisperlink.whisperlink.controllers;
import com.whisperlink.whisperlink.dao.LocationRepository;
import com.whisperlink.whisperlink.models.Location;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/locations")
public class LocationController {

    private final LocationRepository locationRepository;

    @Autowired
    public LocationController(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    // GET za vse zapise
    @GetMapping
    public ResponseEntity<List<Location>> allLocations() {
        List<Location> locations = (List<Location>) locationRepository.findAll();
        return new ResponseEntity<>(locations, HttpStatus.OK);
    }

    // GET za ID
    @GetMapping("/{id}")
    public ResponseEntity<Location> locationOnId(@PathVariable Long id) {
        Optional<Location> location = locationRepository.findById(id);
        return location.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // POST dodajanje zapisa
    @PostMapping
    public ResponseEntity<Location> addLocation(@RequestBody Location newLocation) {
        Location savedLocation = locationRepository.save(newLocation);
        return new ResponseEntity<>(savedLocation, HttpStatus.CREATED);
    }

    // PUT spreminjanje podatkov zapisa
    @PutMapping("/{id}")
    public ResponseEntity<Location> updateLocation(@PathVariable Long id, @RequestBody Location updatedLocation) {
        if (locationRepository.existsById(id)) {
            updatedLocation.setId(id);
            Location upLocaion = locationRepository.save(updatedLocation);
            return new ResponseEntity<>(upLocaion, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // DELETE brisanje podatkov zapisa
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLocation(@PathVariable Long id) {
        if (lokacijaRepository.existsById(id)) {
            lokacijaRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
