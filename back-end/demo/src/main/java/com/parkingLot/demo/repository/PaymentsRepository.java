package com.parkingLot.demo.repository;

import com.parkingLot.demo.model.Payments;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentsRepository extends JpaRepository<Payments, Integer> {

    List<Payments> findBySoftDeleteFalse();



}
