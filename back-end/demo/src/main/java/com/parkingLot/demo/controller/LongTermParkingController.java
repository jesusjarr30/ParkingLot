package com.parkingLot.demo.controller;

import com.parkingLot.demo.InterfaceApi.LongTermParkingDeclaration;
import com.parkingLot.demo.Service.LongTermParkingServie;
import com.parkingLot.demo.model.LongTermParking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/LongTermParking")
@RestController
public class LongTermParkingController implements LongTermParkingDeclaration {

    @Autowired
    private LongTermParkingServie longTermParkingServie;

    @PostMapping("/addlongTermParking")
    @Override
    public ResponseEntity<String> addLongTermParking(@RequestBody LongTermParking ltp) {
        return longTermParkingServie.addLongTermParking(ltp);
    }
    @GetMapping("/getLongTermParking")
    @Override
    public ResponseEntity<List<LongTermParking>> getAllLongTermParking() {
        return longTermParkingServie.getAlluserCategories();
    }
    @PutMapping("/EditLongTermPerking/{id}")
    @Override
    public ResponseEntity<String> EditLongTermParking(@PathVariable("id")int id, @RequestBody LongTermParking ltp) {
        return longTermParkingServie.EditUserCategories(id,ltp);
    }
@DeleteMapping("/Softdelete/{id}")
    @Override
    public ResponseEntity<String> softDeleteLongTermParking(@PathVariable("id") int id) {
        return longTermParkingServie.softDelete(id);
    }
}
