package com.parkingLot.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Entity
@Table(name="parking")
public class Parking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 100)
    private String name;
    @Column(length = 100)
    private String location;
    private int spaces;
    private int unavailable;
    private int idPrices;
    private boolean softDelete;
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public Parking(int id, String name, String location, int spaces, int unavailable, int idPrices, boolean softDelete, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.spaces = spaces;
        this.unavailable = unavailable;
        this.idPrices = idPrices;
        this.softDelete = softDelete;
        this.createdAt = createdAt;
    }
    public Parking(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getSpaces() {
        return spaces;
    }

    public void setSpaces(int spaces) {
        this.spaces = spaces;
    }

    public int getUnavailable() {
        return unavailable;
    }

    public void setUnavailable(int unavailable) {
        this.unavailable = unavailable;
    }

    public boolean isSoftDelete() {
        return softDelete;
    }

    public void setSoftDelete(boolean softDelete) {
        this.softDelete = softDelete;
    }

    public int getIdPrices() {
        return idPrices;
    }

    public void setIdPrices(int idPrices) {
        this.idPrices = idPrices;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
