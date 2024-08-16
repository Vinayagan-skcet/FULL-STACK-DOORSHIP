package com.example.doorship.service;

import com.example.doorship.dto.DashboardDto;

import java.util.List;

public interface DashboardService {

    List<DashboardDto> getAllDashboards();
    DashboardDto getDashboardById(Long id);
    DashboardDto createDashboard(DashboardDto dashboardDto);
    DashboardDto updateDashboard(Long id, DashboardDto dashboardDto);
    void deleteDashboard(Long id);
}
