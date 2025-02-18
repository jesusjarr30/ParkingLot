package com.parkingLot.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name="cost")
public class Cost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int idTicket;
    private boolean lost;//por si se perdio el boleto
    private double extraCharge;
    private double total;
    private boolean softDelete;

    public Cost(int id, int idTicket, boolean lost, double total, double extraCharge, boolean softDelete) {
        this.id = id;
        this.idTicket = idTicket;
        this.lost = lost;
        this.total = total;
        this.extraCharge = extraCharge;
        this.softDelete = softDelete;
    }
    public Cost(){

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

    public double getExtraCharge() {
        return extraCharge;
    }

    public void setExtraCharge(double extraCharge) {
        this.extraCharge = extraCharge;
    }

    public boolean isLost() {
        return lost;
    }

    public void setLost(boolean lost) {
        this.lost = lost;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public boolean isSoftDelete() {
        return softDelete;
    }

    public void setSoftDelete(boolean softDelete) {
        this.softDelete = softDelete;
    }
}
