package com.example.doorship.entity;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "history")
public class History {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 private String orderId;
 private String date;
 private String total;

 @ElementCollection
 private List<String> items;

 // Getters and setters
 public Long getId() {
     return id;
 }

 public void setId(Long id) {
     this.id = id;
 }

 public String getOrderId() {
     return orderId;
 }

 public void setOrderId(String orderId) {
     this.orderId = orderId;
 }

 public String getDate() {
     return date;
 }

 public void setDate(String date) {
     this.date = date;
 }

 public String getTotal() {
     return total;
 }

 public void setTotal(String total) {
     this.total = total;
 }

 public List<String> getItems() {
     return items;
 }

 public void setItems(List<String> items) {
     this.items = items;
 }
}
