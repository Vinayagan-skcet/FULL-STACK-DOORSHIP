package com.example.doorship.service;



import com.example.doorship.dto.LocationDto;
import com.example.doorship.dto.OrderDto;

import java.util.List;

public interface LocationService {

    List<LocationDto> getAllLocations();
    LocationDto getLocationById(Long id);
    LocationDto createLocation(LocationDto locationDTO);
    LocationDto updateLocation(Long id,LocationDto locationDTO);
    void deleteLocation(Long id);
    LocationDto calculateDelivery(String fromAddress, String toAddress);
	
}
