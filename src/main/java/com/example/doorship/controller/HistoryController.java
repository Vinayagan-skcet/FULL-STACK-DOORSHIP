package com.example.doorship.controller;


import com.example.doorship.dto.HistoryDto;
import com.example.doorship.dto.LocationDto;
import com.example.doorship.service.HistoryService;
import com.example.doorship.service.LocationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/history")
public class HistoryController {

    @Autowired
    private LocationService historyService;

    @GetMapping
    public List<LocationDto> getAllLocation() {
        return historyService.getAllLocations();
    }

    @GetMapping("/{id}")
    public LocationDto getLocationsById(@PathVariable Long id) {
        return historyService.getLocationById(id);
    }
}
