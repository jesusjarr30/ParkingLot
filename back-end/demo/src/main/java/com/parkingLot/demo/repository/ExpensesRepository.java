package com.parkingLot.demo.repository;

import com.parkingLot.demo.model.Expenses;
import com.parkingLot.demo.model.Parking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.security.cert.Extension;
import java.util.List;

public interface ExpensesRepository extends JpaRepository<Expenses, Integer> {


    public List<Expenses> findBySoftDeleteFalse();
}
