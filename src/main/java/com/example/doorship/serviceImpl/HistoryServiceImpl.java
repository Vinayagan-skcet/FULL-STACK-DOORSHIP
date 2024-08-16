package com.example.doorship.serviceImpl;

import com.example.doorship.dto.HistoryDto;
import com.example.doorship.entity.History;
import com.example.doorship.mapper.HistoryMapper;
import com.example.doorship.repository.HistoryRepository;
import com.example.doorship.service.HistoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HistoryServiceImpl implements HistoryService {

    @Autowired
    private HistoryRepository historyRepository;

    @Autowired
    private HistoryMapper historyMapper;

    @Override
    public List<HistoryDto> getAllLocations() {
        return historyRepository.findAll()
                .stream()
                .map(historyMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public HistoryDto getLocationsById(String id) {
        History history = historyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("History not found"));
        return historyMapper.toDTO(history);
    }
}
