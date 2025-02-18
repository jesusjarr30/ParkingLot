package com.parkingLot.demo.InterfaceApi;

import com.parkingLot.demo.model.Company;
import com.parkingLot.demo.model.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface CustomerDeclaration {

    @PostMapping("/add")
    public ResponseEntity<String> addCustomer(@RequestBody Customer c);

    @GetMapping("/getCustomer")
    public ResponseEntity<List<Customer>>  getAllCustomer();

    @PutMapping("/EditCustomer/{id}")
    public ResponseEntity<String>  EditCustomer(@PathVariable("id") int id, @RequestBody Customer c);

    @DeleteMapping("/DeleteCustomer/{id}")
    public ResponseEntity<String> softDeleteCustomer(int id);
}
