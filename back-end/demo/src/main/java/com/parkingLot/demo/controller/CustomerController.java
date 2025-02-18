package com.parkingLot.demo.controller;

import com.parkingLot.demo.InterfaceApi.CustomerDeclaration;
import com.parkingLot.demo.Service.CustomerService;
import com.parkingLot.demo.model.Company;
import com.parkingLot.demo.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/customer")
@RestController
public class CustomerController implements CustomerDeclaration {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/addCustomer")
    @Override
    public ResponseEntity<String> addCustomer(@RequestBody  Customer c) {
        return customerService.addCustomer(c);
    }
    @GetMapping("/getCustomer")
    @Override
    public ResponseEntity<List<Customer>> getAllCustomer() {
        return customerService.getAllCustomer();
    }
    @PutMapping("/editCustomer/{id}")
    @Override
    public ResponseEntity<String> EditCustomer(@PathVariable("id") int id, @RequestBody Customer c) {
        return customerService.EditCustomer(id,c);
    }

    @DeleteMapping("/softDelete/{id}")
    @Override
    public ResponseEntity<String> softDeleteCustomer(@PathVariable("id") int id) {
        return customerService.softDelete(id);
    }
}
