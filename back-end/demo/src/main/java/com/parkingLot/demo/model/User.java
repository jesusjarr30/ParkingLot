package com.parkingLot.demo.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 100)
    private String name;
    @Column(length = 15)
    private String socialNumber;
    @Column(length = 15)
    private String RFC;
    @Column(length = 15)
    private String number;
    private int idSupervisor;
    private int idCategories;
    @Column(length = 100)
    private String password;
    private boolean softDelete;
    private LocalDateTime createdAt;

    public User(int id, String name, String RFC, String socialNumber, int idSupervisor, String number, int idCategories, String password, boolean softDelete, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.RFC = RFC;
        this.socialNumber = socialNumber;
        this.idSupervisor = idSupervisor;
        this.number = number;
        this.idCategories = idCategories;
        this.password = password;
        this.softDelete = softDelete;
        this.createdAt = createdAt;
    }
    public User(){

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

    public String getSocialNumber() {
        return socialNumber;
    }

    public void setSocialNumber(String socialNumber) {
        this.socialNumber = socialNumber;
    }

    public String getRFC() {
        return RFC;
    }

    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getIdSupervisor() {
        return idSupervisor;
    }

    public void setIdSupervisor(int idSupervisor) {
        this.idSupervisor = idSupervisor;
    }

    public int getIdCategories() {
        return idCategories;
    }

    public void setIdCategories(int idCategories) {
        this.idCategories = idCategories;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isSoftDelete() {
        return softDelete;
    }

    public void setSoftDelete(boolean softDelete) {
        this.softDelete = softDelete;
    }
}
