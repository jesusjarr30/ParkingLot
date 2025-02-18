package com.parkingLot.demo.InterfaceApi;

import com.parkingLot.demo.model.Company;
import com.parkingLot.demo.model.UserCategories;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface CompanyDeclaration {
    @PostMapping("/add")
    public ResponseEntity<String> addCompany(@RequestBody Company C);

    @GetMapping("/getAllCompany")
    public ResponseEntity<List<Company>>  getAllCompany();

    @PutMapping("/EditCompany/{id}")
    public ResponseEntity<String>  EditUserCategories(@PathVariable("id") int id, @RequestBody Company c);

    @DeleteMapping("/DeleteCompany/{id}")
    public ResponseEntity<String>  softDelete(int id);


}
