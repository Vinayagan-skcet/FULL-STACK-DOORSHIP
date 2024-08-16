package com.example.doorship.repository;

import com.example.doorship.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
    // Additional query methods can be defined here if needed
}
