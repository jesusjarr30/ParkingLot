package com.parkingLot.demo.InterfaceApi;

import com.parkingLot.demo.model.Parking;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ParkingDeclaration {

    @PostMapping("/addParking")
    public ResponseEntity<String> addParking(@RequestBody Parking parking);

    @GetMapping("/getAllParking")
    public ResponseEntity<List<Parking>>  getAllparking();

}
