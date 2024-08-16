package com.example.doorship.serviceImpl;

import com.example.doorship.dto.DashboardDto;
import com.example.doorship.entity.Dashboard;
import com.example.doorship.repository.DashboardRepository;
import com.example.doorship.service.DashboardService;
import com.example.doorship.mapper.DashboardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DashboardServiceImpl implements DashboardService {

    @Autowired
    private DashboardRepository dashboardRepository;

    @Autowired
    private DashboardMapper dashboardMapper;

    @Override
    public List<DashboardDto> getAllDashboards() {
        return dashboardRepository.findAll()
                .stream()
                .map(dashboardMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DashboardDto getDashboardById(Long id) {
        Dashboard dashboard = dashboardRepository.findById(id).orElseThrow(() -> new RuntimeException("Dashboard not found"));
        return dashboardMapper.toDTO(dashboard);
    }

    @Override
    public DashboardDto createDashboard(DashboardDto dashboardDto) {
        Dashboard dashboard = dashboardMapper.toEntity(dashboardDto);
        dashboard = dashboardRepository.save(dashboard);
        return dashboardMapper.toDTO(dashboard);
    }

    @Override
    public DashboardDto updateDashboard(Long id, DashboardDto dashboardDTO) {
        Dashboard dashboard = dashboardRepository.findById(id).orElseThrow(() -> new RuntimeException("Dashboard not found"));
        dashboard.setName(dashboardDTO.getName());
        dashboard.setDistance(dashboardDTO.getDistance());
        dashboard.setPrice(dashboardDTO.getPrice());
        dashboard = dashboardRepository.save(dashboard);
        return dashboardMapper.toDTO(dashboard);
    }

    @Override
    public void deleteDashboard(Long id) {
        dashboardRepository.deleteById(id);
    }
}
