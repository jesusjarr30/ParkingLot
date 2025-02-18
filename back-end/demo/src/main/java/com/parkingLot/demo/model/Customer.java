package com.parkingLot.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name="customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 100)
    private String name;
    private int idCompany;
    @Column(length = 15)
    private String plateCar;
    @Column(length = 50)
    private String brand;
    private int year;
    @Column(length = 15)
    private String color;
    private boolean active;


    public Customer(int id, String name, int idCompany, String plateCar, int year, String brand, String color, boolean active) {
        this.id = id;
        this.name = name;
        this.idCompany = idCompany;
        this.plateCar = plateCar;
        this.year = year;
        this.brand = brand;
        this.color = color;
        this.active = active;
    }
    public Customer(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(int idCompany) {
        this.idCompany = idCompany;
    }

    public String getPlateCar() {
        return plateCar;
    }

    public void setPlateCar(String plateCar) {
        this.plateCar = plateCar;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
