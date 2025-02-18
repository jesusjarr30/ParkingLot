package com.parkingLot.demo.repository;

import com.parkingLot.demo.model.Invoices;
import com.parkingLot.demo.model.Parking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvoicesRepository extends JpaRepository<Invoices, Integer> {

    public List<Invoices> findBySoftDeleteFalse();
}
