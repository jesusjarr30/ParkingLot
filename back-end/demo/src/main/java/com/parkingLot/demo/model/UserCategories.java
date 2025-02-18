package com.parkingLot.demo.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
@Entity
@Table(name="userCategories")

public class UserCategories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String role;
    private boolean softDelete;
    private LocalDateTime createdAt;

    public UserCategories(String role, int id, boolean softDelete, LocalDateTime createdAt) {
        this.role = role;
        this.id = id;
        this.softDelete = softDelete;
        this.createdAt = createdAt;
    }
    public UserCategories(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isSoftDelete() {
        return softDelete;
    }

    public void setSoftDelete(boolean softDelete) {
        this.softDelete = softDelete;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}


