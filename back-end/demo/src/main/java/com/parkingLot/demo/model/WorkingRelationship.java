package com.parkingLot.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name="workingRelationship")
public class WorkingRelationship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int idUser;
    private int idParking;
    private boolean softDelete;

    public WorkingRelationship(int id, int idUser, int idParking,boolean softDelete) {
        this.id = id;
        this.idUser = idUser;
        this.idParking = idParking;
        this.softDelete = softDelete;
    }
    public WorkingRelationship(){

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

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdParking() {
        return idParking;
    }

    public void setIdParking(int idParking) {
        this.idParking = idParking;
    }
}
