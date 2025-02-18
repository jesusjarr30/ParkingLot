package com.parkingLot.demo.Service;

import com.parkingLot.demo.model.Cost;
import com.parkingLot.demo.repository.CostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CostService {

    @Autowired
    private CostRepository costRepository;

    public ResponseEntity<String> add(Cost c) {
        costRepository.save(c);
        return new ResponseEntity<>("Se registro la categoria del usuario", HttpStatus.OK);
    }

    public ResponseEntity<List<Cost>> getAll(){
        List<Cost> companyList = costRepository.findBySoftDeleteFalse();
        if(companyList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(companyList);
    }

    public ResponseEntity<String> Edit(int id, Cost c) {
        Optional<Cost> companyOptional= costRepository.findById(id);
        if(!companyOptional.isPresent()){
            return ResponseEntity.notFound().build();
        }
        costRepository.save(c);
        return ResponseEntity.ok().build();
    }


    public ResponseEntity<String> softDelete(int id) {
        Optional<Cost>ucOptional = costRepository.findById(id);
        if(!ucOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        Cost uc = ucOptional.get();
        uc.setSoftDelete(true);
        costRepository.save(uc);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
