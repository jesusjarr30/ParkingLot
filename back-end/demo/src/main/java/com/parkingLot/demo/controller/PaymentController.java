package com.parkingLot.demo.controller;

import com.parkingLot.demo.Service.CompanyService;
import com.parkingLot.demo.Service.PaymentsService;
import com.parkingLot.demo.model.Company;
import com.parkingLot.demo.model.Payments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/payments")
@RestController
public class PaymentController {

    @Autowired
    private PaymentsService paymentsService;

    @PostMapping("/add")
    public ResponseEntity<String> addCompany(@RequestBody Payments c) {
        return paymentsService.add(c);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Payments>> getAllCompany() {
        return paymentsService.getAll();
    }
    @PutMapping("/editar/{id}")

    public ResponseEntity<String> EditUserCategories(@PathVariable("id") int id, @RequestBody Payments c) {
        return paymentsService.Edit(id,c);
    }
    @DeleteMapping("/sofDelete/{id}")
    public ResponseEntity<String> softDelete(@PathVariable("id") int id) {
        return paymentsService.softDelete(id);
    }
}
