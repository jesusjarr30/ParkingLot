package com.parkingLot.demo.controller;

import com.parkingLot.demo.repository.ParkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParkingController {
    @Autowired
    private ParkingRepository parkingRepository;

    public void getAllparking(){

    }
    public void getBookbyId(){

    }

}
