package com.parkingLot.demo.controller;

import com.parkingLot.demo.InterfaceApi.ParkingDeclaration;
import com.parkingLot.demo.Service.ParkingService;
import com.parkingLot.demo.model.Parking;
import com.parkingLot.demo.model.UserCategories;
import com.parkingLot.demo.repository.ParkingRepository;
import com.parkingLot.demo.repository.UserCategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/parking")
@RestController
public class ParkingController implements ParkingDeclaration {
    @Autowired
    private ParkingService parkingService;
    private UserCategoriesRepository userCategoriesRepository;

    @GetMapping("/getAllParking")
    public ResponseEntity<List<Parking>>  getAllparking(){
        return parkingService.getParking();
    }

    @PostMapping("/addParking")
    public ResponseEntity<String> addParking(@RequestBody Parking parking) {
        return parkingService.addParking(parking);
    }

    @GetMapping("/freeSpace")
    public ResponseEntity<Integer> getFreeSpace(int id){
        int availableSpaces = parkingService.getTotalAvailableSpaces(id); // Obtén el valor entero
        return ResponseEntity.ok(availableSpaces);
    }
}
