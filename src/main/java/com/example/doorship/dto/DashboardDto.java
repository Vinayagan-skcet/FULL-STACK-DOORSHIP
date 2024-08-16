package com.example.doorship.dto;


public class DashboardDto {

    private Long id;
    private String name;
    private int distance;
    private double price;

    // Constructors
    public DashboardDto() {}

    public DashboardDto(Long id, String name, int distance, double price) {
        this.id = id;
        this.name = name;
        this.distance = distance;
        this.price = price;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
