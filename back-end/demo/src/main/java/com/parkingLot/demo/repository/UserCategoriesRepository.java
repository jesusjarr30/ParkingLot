package com.parkingLot.demo.repository;


import com.parkingLot.demo.model.UserCategories;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserCategoriesRepository extends JpaRepository<UserCategories, Integer> {

        List<UserCategories> findBySoftDeleteFalse();

}
