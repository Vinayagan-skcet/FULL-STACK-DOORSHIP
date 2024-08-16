package com.example.doorship.dto;

public class OrderDto {

    private Long id;
    private String notes;
    private String imageSrc;

    // Constructors, Getters, and Setters
    public OrderDto() {}

    public OrderDto(Long id, String notes, String imageSrc) {
        this.id = id;
        this.notes = notes;
        this.imageSrc = imageSrc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc;
    }
}
