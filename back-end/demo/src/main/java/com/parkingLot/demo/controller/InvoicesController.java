package com.parkingLot.demo.controller;

import com.parkingLot.demo.InterfaceApi.InvoicesDeclaration;
import com.parkingLot.demo.model.Invoices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class InvoicesController implements InvoicesDeclaration {
    @Autowired
    private InvoicesController invoicesController;

    @PostMapping("/addInvoices")
    @Override
    public ResponseEntity<String> addInvoices(@RequestBody Invoices i) {
        return invoicesController.addInvoices(i);
    }
    @GetMapping("/getInvoices")
    @Override
    public ResponseEntity<List<Invoices>> getAllInvoices() {
        return invoicesController.getAllInvoices();
    }
    @PutMapping("/editInvoices")
    @Override
    public ResponseEntity<String> EditInvoices(@PathVariable("id") int id, @RequestBody Invoices i) {
        return invoicesController.EditInvoices(id,i);
    }
    @DeleteMapping("/softDelete/{id}")
    @Override
    public ResponseEntity<String> softDeleteInvoices(@PathVariable("id") int id) {
        return invoicesController.softDeleteInvoices(id);
    }
}
