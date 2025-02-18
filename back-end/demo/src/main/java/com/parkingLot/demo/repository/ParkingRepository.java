package com.parkingLot.demo.repository;

import com.parkingLot.demo.model.Parking;
import com.parkingLot.demo.model.Payments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParkingRepository extends JpaRepository<Parking, Integer> {

    List<Parking> findBySoftDeleteFalse();

    @Query(value = "SELECT (p.spaces-(COUNT(t.id) - p.unavailable + COUNT(ltp.id))) FROM parking p " +
            "LEFT JOIN ticket t ON p.id = t.id_parking AND t.idltp IS NULL AND t.active = TRUE " +
            "LEFT JOIN long_term_parking ltp ON p.id = ltp.id_parking AND ltp.soft_delete = FALSE " +
            "WHERE p.id = :parkingId " +
            "GROUP BY p.id", nativeQuery = true)
    int getTotalAvailableSpaces(@Param("parkingId") int parkingId);
}
