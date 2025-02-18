package com.parkingLot.demo.repository;

import com.parkingLot.demo.model.User;
import com.parkingLot.demo.model.UserCategories;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findBySoftDeleteFalse();
}
