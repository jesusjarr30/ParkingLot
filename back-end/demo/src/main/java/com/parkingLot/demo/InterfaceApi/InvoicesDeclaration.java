package com.parkingLot.demo.InterfaceApi;

import com.parkingLot.demo.model.Company;
import com.parkingLot.demo.model.Invoices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface InvoicesDeclaration {

    @PostMapping("/add")
    public ResponseEntity<String> addInvoices(@RequestBody Invoices i);

    @GetMapping("/getAllInvoices")
    public ResponseEntity<List<Invoices>>  getAllInvoices();

    @PutMapping("/EditInvoices/{id}")
    public ResponseEntity<String>  EditInvoices(@PathVariable("id") int id, @RequestBody Invoices i);

    @DeleteMapping("/DeleteInvoices/{id}")
    public ResponseEntity<String>  softDeleteInvoices(int id);
}
