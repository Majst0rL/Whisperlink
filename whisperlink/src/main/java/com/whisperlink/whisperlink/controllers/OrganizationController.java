package com.whisperlink.whisperlink.controllers;

import com.whisperlink.whisperlink.dao.OrganizationRepository;
import com.whisperlink.whisperlink.models.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/organizations")
public class OrganizationController {

    private final OrganizationRepository organizationRepository;

    @Autowired
    public OrganizationController(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    @GetMapping("/")
    public Iterable<Organization> getAllOrganizations() {
        return organizationRepository.findAll();
    }

    @GetMapping("/{id}")
    public Organization getOrganizationById(@PathVariable("id") Long id) {
        return organizationRepository.findById(id).orElse(null);
    }

    @PostMapping("/")
    public Organization createOrganization(@RequestBody Organization newOrganization) {
        return organizationRepository.save(newOrganization);
    }

    @PutMapping("/{id}")
    public Organization updateOrganization(@PathVariable("id") Long id, @RequestBody Organization updatedOrganization) {
        updatedOrganization.setId(id); // Preserve the ID from the path variable
        return organizationRepository.save(updatedOrganization);
    }

    @DeleteMapping("/{id}")
    public void deleteOrganization(@PathVariable("id") Long id) {
        organizationRepository.deleteById(id);
    }

}
