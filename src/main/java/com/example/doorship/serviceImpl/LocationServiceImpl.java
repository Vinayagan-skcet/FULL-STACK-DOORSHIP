package com.example.doorship.serviceImpl;

import com.example.doorship.dto.LocationDto;
import com.example.doorship.dto.OrderDto;
import com.example.doorship.dto.LocationDto;
import com.example.doorship.entity.Location;
import com.example.doorship.entity.Order;
import com.example.doorship.entity.signup;
import com.example.doorship.exception.ResourceNotFoundException;
import com.example.doorship.mapper.LocationMapper;
import com.example.doorship.mapper.signupmapper;
import com.example.doorship.repository.LocationRepository;
import com.example.doorship.service.LocationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepository locationRepository;

   
    
    @Override
    public LocationDto createLocation(LocationDto LocationDto) {

       Location signup = LocationMapper.toEntity(LocationDto);
        Location savedsignup = locationRepository.save(signup);
        return LocationMapper.toDTO(savedsignup);
    }
    
    
    @Override
    public LocationDto getLocationById(Long SignupId) {
       Location auth = locationRepository.findById(SignupId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee is not exists with given id : " + SignupId));

        return LocationMapper.toDTO(auth);
    }

    @Override
    public List<LocationDto> getAllLocations() {
        List<Location> auths = locationRepository.findAll();
        return auths.stream().map((auth) -> LocationMapper.toDTO(auth))
                .collect(Collectors.toList());
    }

   

    @Override
    public void deleteLocation(Long SignupId) {

        Location auth = locationRepository.findById(SignupId).orElseThrow(
                () -> new ResourceNotFoundException("Location id: " +SignupId)
        );

        locationRepository.deleteById(SignupId);
    }



  
    
    @Override
    public LocationDto updateLocation(Long id, LocationDto updatedSignup) {
    	
    	Location auth = locationRepository.findById(id).orElseThrow(
    			() -> new ResourceNotFoundException("Location id: " + id)
    			);
    	auth.setFromAddress(updatedSignup.getFromAddress());
    	auth.setToAddress(updatedSignup.getToAddress());
    	
    	
    	Location updatedsignupObj = locationRepository.save(auth);
    	
    	return LocationMapper.toDTO(updatedsignupObj);
    }


	@Override
	public LocationDto calculateDelivery(String fromAddress, String toAddress) {
		// TODO Auto-generated method stub
		return null;
	}

   
   

   
    }


