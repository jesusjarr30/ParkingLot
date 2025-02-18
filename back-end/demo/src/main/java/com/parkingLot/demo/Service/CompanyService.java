package com.parkingLot.demo.Service;

import com.parkingLot.demo.model.Company;
import com.parkingLot.demo.model.UserCategories;
import com.parkingLot.demo.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public ResponseEntity<String> addCompany(Company c) {
        companyRepository.save(c);
        return new ResponseEntity<>("Se registro la categoria del usuario", HttpStatus.OK);
    }


    public ResponseEntity<List<Company>> getAllCompany() {
        List<Company> companyList = companyRepository.findBySoftDeleteFalse();
        if(companyList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(companyList);
    }


    public ResponseEntity<String> EditCompany(int id, Company c) {
        Optional<Company> companyOptional= companyRepository.findById(id);
        if(!companyOptional.isPresent()){
            return ResponseEntity.notFound().build();
        }
        companyRepository.save(c);
        return ResponseEntity.ok().build();
    }


    public ResponseEntity<String> softDelete(int id) {
        Optional<Company>ucOptional = companyRepository.findById(id);
        if(!ucOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        Company uc = ucOptional.get();
        uc.setSoftDelete(true);
        companyRepository.save(uc);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
