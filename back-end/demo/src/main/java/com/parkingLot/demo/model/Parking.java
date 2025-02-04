package com.parkingLot.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name="parking")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Parking {

    private int id;
    private String name;
    private String location;
    private int spaces;
    private int unavailable;
    private int idPrices;
    private boolean softDelete;
    private

}
