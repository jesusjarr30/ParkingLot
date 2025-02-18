package com.parkingLot.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name="crash")
public class Crash {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int idTicket;
    private String driverName;
    private String plate;
    private String licenseDriver;
    private String details;
    private double cost;
    private char status;
    private boolean softDelete;

    public Crash(int id, String driverName, int idTicket, String plate, String licenseDriver, String details, double cost, char status,boolean softDelete) {
        this.id = id;
        this.driverName = driverName;
        this.idTicket = idTicket;
        this.plate = plate;
        this.licenseDriver = licenseDriver;
        this.details = details;
        this.cost = cost;
        this.status = status;
        this.softDelete=softDelete;
    }

    public Crash(){

    }
    public boolean isSoftDelete() {
        return softDelete;
    }

    public void setSoftDelete(boolean softDelete) {
        this.softDelete = softDelete;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getLicenseDriver() {
        return licenseDriver;
    }

    public void setLicenseDriver(String licenseDriver) {
        this.licenseDriver = licenseDriver;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }
}
