package com.parkingLot.demo.repository;

import com.parkingLot.demo.model.Parking;
import com.parkingLot.demo.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketsRepository extends JpaRepository<Ticket, Integer> {

    public List<Ticket> findBySoftDeleteFalse();
}
