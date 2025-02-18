package com.parkingLot.demo.repository;

import com.parkingLot.demo.model.LongTermParking;
import com.parkingLot.demo.model.Parking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LongTermParkingRepository extends JpaRepository<LongTermParking, Integer> {

    public List<LongTermParking> findBySoftDeleteFalse();
}
