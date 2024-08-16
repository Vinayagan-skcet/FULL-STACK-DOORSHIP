package com.example.doorship.service;

import com.example.doorship.dto.HistoryDto;
import java.util.List;

public interface HistoryService {
    List<HistoryDto> getAllLocations();
    HistoryDto getLocationsById(String id);
}
