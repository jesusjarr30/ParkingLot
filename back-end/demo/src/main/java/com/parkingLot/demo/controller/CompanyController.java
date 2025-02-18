package com.parkingLot.demo.controller;

import com.parkingLot.demo.InterfaceApi.CompanyDeclaration;
import com.parkingLot.demo.Service.CompanyService;
import com.parkingLot.demo.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/company")
@RestController
public class CompanyController implements CompanyDeclaration {
    @Autowired
    private CompanyService companyService;

    @PostMapping("/addCompany")
    @Override
    public ResponseEntity<String> addCompany(@RequestBody Company c) {
        return companyService.addCompany(c);
    }
    @GetMapping("/getAllCompany")
    @Override
    public ResponseEntity<List<Company>> getAllCompany() {
        return companyService.getAllCompany();
    }
    @PutMapping("/editarCompany/{id}")
    @Override
    public ResponseEntity<String> EditUserCategories(@PathVariable("id") int id, @RequestBody Company c) {
        return companyService.EditCompany(id,c);
    }
    @DeleteMapping("/sofDeleteCompany/{id}")
    @Override
    public ResponseEntity<String> softDelete(@PathVariable("id") int id) {
        return companyService.softDelete(id);
    }
}
