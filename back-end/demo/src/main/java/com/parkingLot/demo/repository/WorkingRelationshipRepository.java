package com.parkingLot.demo.repository;

import com.parkingLot.demo.model.Parking;
import com.parkingLot.demo.model.User;
import com.parkingLot.demo.model.WorkingRelationship;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkingRelationshipRepository extends JpaRepository<WorkingRelationship, Integer> {

    List<WorkingRelationship> findBySoftDeleteFalse();
}
