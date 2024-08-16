package com.example.doorship.mapper;


import com.example.doorship.dto.HistoryDto;
import com.example.doorship.entity.History;

import org.springframework.stereotype.Component;

@Component
public class HistoryMapper {

 public HistoryDto toDTO(History history) {
     HistoryDto historyDTO = new HistoryDto();
     historyDTO.setId(history.getId());
     historyDTO.setOrderId(history.getOrderId());
     historyDTO.setDate(history.getDate());
     historyDTO.setTotal(history.getTotal());
     historyDTO.setItems(history.getItems());
     return historyDTO;
 }

 public History toEntity(HistoryDto historyDTO) {
     History history = new History();
     history.setId(historyDTO.getId());
     history.setOrderId(historyDTO.getOrderId());
     history.setDate(historyDTO.getDate());
     history.setTotal(historyDTO.getTotal());
     history.setItems(historyDTO.getItems());
     return history;
 }
}
