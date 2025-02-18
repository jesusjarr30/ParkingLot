package com.parkingLot.demo.InterfaceApi;

import com.parkingLot.demo.model.Company;
import com.parkingLot.demo.model.LongTermParking;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface LongTermParkingDeclaration {
    @PostMapping("/add")
    public ResponseEntity<String> addLongTermParking(@RequestBody LongTermParking ltp);

    @GetMapping("/getAllCompany")
    public ResponseEntity<List<LongTermParking>>  getAllLongTermParking();

    @PutMapping("/EditCompany/{id}")
    public ResponseEntity<String>  EditLongTermParking(@PathVariable("id") int id, @RequestBody LongTermParking ltp);

    @DeleteMapping("/DeleteLongTermParking/{id}")
    public ResponseEntity<String>  softDeleteLongTermParking(int id);
}
