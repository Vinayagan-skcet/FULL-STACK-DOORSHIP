package com.example.doorship.mapper;

import com.example.doorship.dto.LocationDto;
import com.example.doorship.entity.Location;
import org.springframework.stereotype.Component;

@Component
public class LocationMapper {

    public static LocationDto toDTO(Location location) {
        return new LocationDto(
                location.getId(),
                location.getFromAddress(),
                location.getToAddress()
               
        );
    }

    public static Location toEntity(LocationDto locationDTO) {
        return new Location(
        		locationDTO.getId(),
                locationDTO.getFromAddress(),
                locationDTO.getToAddress()

        );
    }
}
