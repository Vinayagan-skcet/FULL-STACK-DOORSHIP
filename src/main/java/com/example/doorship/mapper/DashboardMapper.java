package com.example.doorship.mapper;

import com.example.doorship.dto.DashboardDto;
import com.example.doorship.entity.Dashboard;
import org.springframework.stereotype.Component;

@Component
public class DashboardMapper {

    public DashboardDto toDTO(Dashboard dashboard) {
        return new DashboardDto(
                dashboard.getId(),
                dashboard.getName(),
                dashboard.getDistance(),
                dashboard.getPrice()
        );
    }

    public Dashboard toEntity(DashboardDto dashboardDTO) {
        return new Dashboard(
                dashboardDTO.getName(),
                dashboardDTO.getDistance(),
                dashboardDTO.getPrice()
        );
    }
}
