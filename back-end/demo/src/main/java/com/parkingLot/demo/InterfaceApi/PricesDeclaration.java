package com.parkingLot.demo.InterfaceApi;

import com.parkingLot.demo.model.Company;
import com.parkingLot.demo.model.Expenses;
import com.parkingLot.demo.model.Prices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface PricesDeclaration {

    @PostMapping("/add")
    public ResponseEntity<String> addPrices(@RequestBody Prices p);

    @GetMapping("/getAllPrices")
    public ResponseEntity<List<Prices>>  getAllPrices();

    @PutMapping("/EditPrices/{id}")
    public ResponseEntity<String>  EditPrices(@PathVariable("id") int id, @RequestBody Prices p);

    @DeleteMapping("/DeletePrices/{id}")
    public ResponseEntity<String>  softDeletePrices(int id);
}
