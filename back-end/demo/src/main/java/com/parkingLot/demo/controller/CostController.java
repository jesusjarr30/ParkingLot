package com.parkingLot.demo.controller;

import com.parkingLot.demo.Service.CompanyService;
import com.parkingLot.demo.Service.CostService;
import com.parkingLot.demo.model.Company;
import com.parkingLot.demo.model.Cost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/cost")
@RestController
public class CostController {

    @Autowired
    private CostService costService;

    @PostMapping("/addCompany")
    public ResponseEntity<String> add(@RequestBody Cost c) {
        return costService.add(c);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<Cost>> getAllCompany() {
        return costService.getAll();
    }
    @PutMapping("/editar/{id}")
    public ResponseEntity<String> EditUserCategories(@PathVariable("id") int id, @RequestBody Cost c) {
        return costService.Edit(id,c);
    }
    @DeleteMapping("/sofDelete/{id}")
    public ResponseEntity<String> softDelete(@PathVariable("id") int id) {
        return costService.softDelete(id);
    }

}
