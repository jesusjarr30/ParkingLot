package com.parkingLot.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "payments")
public class Payments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int idCost;
    private double deposit;
    private char method;//credic, cash and debit
    private String card;
    private boolean softDelete;

    public Payments(int id,int idCost, double deposit, char method, String card, boolean softDelete) {
        this.id = id;
        this.idCost=idCost;
        this.deposit = deposit;
        this.method = method;
        this.card = card;
        this.softDelete = softDelete;
    }
    public Payments(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public char getMethod() {
        return method;
    }

    public void setMethod(char method) {
        this.method = method;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public boolean isSoftDelete() {
        return softDelete;
    }

    public void setSoftDelete(boolean softDelete) {
        this.softDelete = softDelete;
    }

    public int getIdCost() {
        return idCost;
    }

    public void setIdCost(int idCost) {
        this.idCost = idCost;
    }
}
