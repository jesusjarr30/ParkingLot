package com.parkingLot.demo.Service;

import com.parkingLot.demo.model.Cost;
import com.parkingLot.demo.model.Payments;
import com.parkingLot.demo.repository.CostRepository;
import com.parkingLot.demo.repository.PaymentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentsService {


    @Autowired
    private PaymentsRepository paymentsRepository;

    public ResponseEntity<String> add(Payments c) {
        paymentsRepository.save(c);
        return new ResponseEntity<>("Se registro la categoria del usuario", HttpStatus.OK);
    }


    public ResponseEntity<List<Payments>> getAll(){
        List<Payments> companyList = paymentsRepository.findBySoftDeleteFalse();
        if(companyList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(companyList);
    }


    public ResponseEntity<String> Edit(int id, Payments c) {
        Optional<Payments> companyOptional= paymentsRepository.findById(id);
        if(!companyOptional.isPresent()){
            return ResponseEntity.notFound().build();
        }
        paymentsRepository.save(c);
        return ResponseEntity.ok().build();
    }


    public ResponseEntity<String> softDelete(int id) {
        Optional<Payments>ucOptional = paymentsRepository.findById(id);
        if(!ucOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        Payments uc = ucOptional.get();
        uc.setSoftDelete(true);
        paymentsRepository.save(uc);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
