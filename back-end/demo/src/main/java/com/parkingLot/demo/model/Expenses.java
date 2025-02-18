package com.parkingLot.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name="expenses")
public class Expenses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int idParking;
    private int idUser;
    private String reason;
    private double price;
    private boolean autorizacion;
    private char status;
    private boolean softDelete;

    public Expenses(int id, int idParking, int idUser, String reason, double price, boolean autorizacion, char status, boolean softDelete) {
        this.id = id;
        this.idParking = idParking;
        this.idUser = idUser;
        this.reason = reason;
        this.price = price;
        this.autorizacion = autorizacion;
        this.status = status;
        this.softDelete = softDelete;
    }
    Expenses(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdParking() {
        return idParking;
    }

    public void setIdParking(int idParking) {
        this.idParking = idParking;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAutorizacion() {
        return autorizacion;
    }

    public void setAutorizacion(boolean autorizacion) {
        this.autorizacion = autorizacion;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public boolean isSoftDelete() {
        return softDelete;
    }

    public void setSoftDelete(boolean softDelete) {
        this.softDelete = softDelete;
    }
}
