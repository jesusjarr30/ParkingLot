package com.parkingLot.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name="company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 100)
    private String name;
    private int NumEployes;
    private double discounts;
    @Column(length = 15)
    private String RFC;
    private boolean softDelete;

    public Company(int id, String name, double discounts, int numEployes, String RFC, boolean softDelete) {
        this.id = id;
        this.name = name;
        this.discounts = discounts;
        NumEployes = numEployes;
        this.RFC = RFC;
        this.softDelete = softDelete;
    }
    public Company(){

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

    public int getNumEployes() {
        return NumEployes;
    }

    public void setNumEployes(int numEployes) {
        NumEployes = numEployes;
    }

    public double getDiscounts() {
        return discounts;
    }

    public void setDiscounts(double discounts) {
        this.discounts = discounts;
    }

    public String getRFC() {
        return RFC;
    }

    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    public boolean isSoftDelete() {
        return softDelete;
    }

    public void setSoftDelete(boolean softDelete) {
        this.softDelete = softDelete;
    }
}
