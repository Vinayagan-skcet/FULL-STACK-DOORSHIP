package com.example.doorship.controller;


import com.example.doorship.dto.DashboardDto;
import com.example.doorship.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dashboards")
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping
    public List<DashboardDto> getAllDashboards() {
        return dashboardService.getAllDashboards();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DashboardDto> getDashboardById(@PathVariable Long id) {
        DashboardDto dashboard = dashboardService.getDashboardById(id);
        return ResponseEntity.ok(dashboard);
    }

    @PostMapping
    public ResponseEntity<DashboardDto> createDashboard(@RequestBody DashboardDto dashboardDTO) {
        DashboardDto newDashboard = dashboardService.createDashboard(dashboardDTO);
        return ResponseEntity.ok(newDashboard);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DashboardDto> updateDashboard(@PathVariable Long id, @RequestBody DashboardDto dashboardDTO) {
        DashboardDto updatedDashboard = dashboardService.updateDashboard(id, dashboardDTO);
        return ResponseEntity.ok(updatedDashboard);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDashboard(@PathVariable Long id) {
        dashboardService.deleteDashboard(id);
        return ResponseEntity.noContent().build();
    }
}
