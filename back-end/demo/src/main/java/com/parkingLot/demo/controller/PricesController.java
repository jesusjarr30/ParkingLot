package com.parkingLot.demo.controller;

import com.parkingLot.demo.Service.PricesService;
import com.parkingLot.demo.model.Prices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/Prices")
@RestController
public class PricesController {
    @Autowired
    private PricesService pricesService;

    @PostMapping("/add")
    public ResponseEntity<String> adduserCategories(@RequestBody Prices prices) {
        return pricesService.addPrices(prices);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Prices>> getPrices() {
        return pricesService.getPrices();
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<List<Prices>> EditUserCategories(@PathVariable("id") int id, @RequestBody Prices uc) {
        return pricesService.EditPrices(id,uc);
    }

    @DeleteMapping("/softDelete/{id}")
    public ResponseEntity<String> softDelete(@PathVariable("id") int id) {
        return pricesService.softDeletePrices(id);
    }

}
