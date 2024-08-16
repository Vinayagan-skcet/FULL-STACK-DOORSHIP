package com.example.doorship.controller;


import com.example.doorship.dto.LocationDto;
import com.example.doorship.dto.LocationDto;
import com.example.doorship.service.LocationService;
import com.example.doorship.service.signupservice;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/locations")
public class LocationController {

    @Autowired
    private LocationService locationservice;

    @PostMapping
    public ResponseEntity<LocationDto> createLocation(@RequestBody LocationDto locationDto) {
        LocationDto savedSignup = locationservice.createLocation(locationDto);
        return new ResponseEntity<>(savedSignup, HttpStatus.CREATED);
    }

    // Build Get signup By ID REST API
    @GetMapping("{id}")
    public ResponseEntity<LocationDto> getLocationById(@PathVariable("id") Long signupId) {
        LocationDto LocationDto = locationservice.getLocationById(signupId);
        return ResponseEntity.ok(LocationDto);
    }

    // Build Get All signups REST API
    @GetMapping
    public ResponseEntity<List<LocationDto>> getAllLocations() {
        List<LocationDto> signups = locationservice.getAllLocations();
        return ResponseEntity.ok(signups);
    }

     //Build Update signup REST API
    @PutMapping("{id}")
    public ResponseEntity<LocationDto> updateLocation(@PathVariable("id") Long signupId, @RequestBody LocationDto updatedSignup) {
        LocationDto LocationDto = locationservice.updateLocation(signupId, updatedSignup);
        return ResponseEntity.ok(LocationDto);
    }

    // Build Delete signup REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteLocation(@PathVariable("id") Long signupId) {
    	locationservice.deleteLocation(signupId);
        return ResponseEntity.ok("Signup deleted successfully!");
    }
}