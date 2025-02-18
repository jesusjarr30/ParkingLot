package com.parkingLot.demo.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name="ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int idParking;
    private int idLTP;
    private boolean active;//meaning the car is still in the parking lot
    private Date start;
    private Date finish;
    private boolean softDelete;


    public Ticket(int id, int idParking, int idLTP, boolean active, Date start, Date finish, boolean softDelete) {
        this.id = id;
        this.idParking = idParking;
        this.idLTP = idLTP;
        this.active = active;
        this.start = start;
        this.finish = finish;
        this.softDelete = softDelete;
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

    public int getIdLTP() {
        return idLTP;
    }

    public void setIdLTP(int idLTP) {
        this.idLTP = idLTP;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getFinish() {
        return finish;
    }

    public void setFinish(Date finish) {
        this.finish = finish;
    }

    public boolean isSoftDelete() {
        return softDelete;
    }

    public void setSoftDelete(boolean softDelete) {
        this.softDelete = softDelete;
    }

    public Ticket() {

    }
}
