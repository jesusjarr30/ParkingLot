package com.parkingLot.demo.repository;

import com.parkingLot.demo.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {

    List<Company> findBySoftDeleteFalse();
}
