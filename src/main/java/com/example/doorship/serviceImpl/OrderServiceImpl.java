package com.example.doorship.serviceImpl;

import com.example.doorship.dto.OrderDto;
import com.example.doorship.entity.Order;
import com.example.doorship.repository.OrderRepository;
import com.example.doorship.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<OrderDto> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public OrderDto getOrderById(Long id) {
        return orderRepository.findById(id)
                .map(this::convertEntityToDto)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    @Override
    public OrderDto createOrder(OrderDto orderDto) {
        Order order = new Order(orderDto.getNotes(), orderDto.getImageSrc());
        Order savedOrder = orderRepository.save(order);
        return convertEntityToDto(savedOrder);
    }

    @Override
    public OrderDto updateOrder(Long id, OrderDto orderDto) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        order.setNotes(orderDto.getNotes());
      //  order.setImageSrc(orderDto.getImageSrc());
        Order updatedOrder = orderRepository.save(order);
        return convertEntityToDto(updatedOrder);
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    private OrderDto convertEntityToDto(Order order) {
        return new OrderDto(order.getId(), order.getNotes(), order.getImageSrc());
    }
}
