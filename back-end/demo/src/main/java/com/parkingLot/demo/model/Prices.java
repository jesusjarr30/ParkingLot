package com.parkingLot.demo.model;

import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name="prices")
public class Prices {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double hourP;
    private double longTerm;
    private boolean softDelete;

    public Prices(int id, double hourP, double longTerm, boolean softDelete) {
        this.id = id;
        this.hourP = hourP;
        this.longTerm = longTerm;
        this.softDelete = softDelete;
    }
    public Prices(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getHourP() {
        return hourP;
    }

    public void setHourP(double hourP) {
        this.hourP = hourP;
    }

    public boolean isSoftDelete() {
        return softDelete;
    }

    public void setSoftDelete(boolean softDelete) {
        this.softDelete = softDelete;
    }

    public double getLongTerm() {
        return longTerm;
    }

    public void setLongTerm(double longTerm) {
        this.longTerm = longTerm;
    }
}
