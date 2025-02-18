package com.parkingLot.demo.repository;

import com.parkingLot.demo.model.Company;
import com.parkingLot.demo.model.Cost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CostRepository extends JpaRepository<Cost, Integer> {
    List<Cost> findBySoftDeleteFalse();
}
