package com.parkingLot.demo.repository;

import com.parkingLot.demo.model.Parking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingRepository extends JpaRepository<Parking, int> {
}
