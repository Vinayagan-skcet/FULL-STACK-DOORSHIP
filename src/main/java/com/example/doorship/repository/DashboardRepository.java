package com.example.doorship.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.doorship.entity.Dashboard;

@Repository
public interface DashboardRepository extends JpaRepository<Dashboard, Long> {
}
