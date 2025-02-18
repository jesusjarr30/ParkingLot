package com.parkingLot.demo.model;

import jakarta.persistence.*;


@Entity
@Table(name="longTermParking")
public class LongTermParking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int idCustomer;
    private int idParking;
    private boolean softDelete;

    public LongTermParking(int id, int idCustomer, int idParking, boolean softDelete) {
        this.id = id;
        this.idCustomer = idCustomer;
        this.idParking = idParking;
        this.softDelete = softDelete;
    }
    public LongTermParking(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCutomer() {
        return idCustomer;
    }

    public void setIdCutomer(int idCutomer) {
        this.idCustomer = idCutomer;
    }

    public int getIdParking() {
        return idParking;
    }

    public void setIdParking(int idParking) {
        this.idParking = idParking;
    }

    public boolean isSoftDelete() {
        return softDelete;
    }

    public void setSoftDelete(boolean softDelete) {
        this.softDelete = softDelete;
    }
}
