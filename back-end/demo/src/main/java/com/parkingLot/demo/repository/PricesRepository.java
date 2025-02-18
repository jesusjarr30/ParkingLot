package com.parkingLot.demo.repository;

import com.parkingLot.demo.model.Parking;
import com.parkingLot.demo.model.Prices;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PricesRepository extends JpaRepository<Prices, Integer> {

    public List<Prices> findBySoftDeleteFalse();
}
