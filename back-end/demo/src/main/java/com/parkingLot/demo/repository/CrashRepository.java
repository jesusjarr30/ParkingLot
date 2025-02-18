package com.parkingLot.demo.repository;

import com.parkingLot.demo.model.Company;
import com.parkingLot.demo.model.Crash;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CrashRepository extends JpaRepository<Crash, Integer> {

    List<Crash> findBySoftDeleteFalse();
}
