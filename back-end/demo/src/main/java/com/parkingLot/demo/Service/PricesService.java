package com.parkingLot.demo.Service;

import com.parkingLot.demo.model.Prices;
import com.parkingLot.demo.repository.PricesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PricesService {
@Autowired
    private PricesRepository pricesRepository;

    public ResponseEntity<String> addPrices(Prices prices) {
        pricesRepository.save(prices);
        return new ResponseEntity<>("Se registro la categoria del usuario", HttpStatus.OK);
    }

    public ResponseEntity<List<Prices>> getPrices() {
        List<Prices> userCategoriesList = pricesRepository.findBySoftDeleteFalse();
        if(userCategoriesList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(userCategoriesList);
    }
    public ResponseEntity<List<Prices>> EditPrices(int id,Prices editar) {
        Optional<Prices> ucOptional = pricesRepository.findById(id);
        if(!ucOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        Prices uc=ucOptional.get();
        pricesRepository.save(editar);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    public ResponseEntity<String> softDeletePrices(int id) {
        Optional<Prices>ucOptional = pricesRepository.findById(id);
        if(!ucOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        Prices uc = ucOptional.get();
        uc.setSoftDelete(true);
        pricesRepository.save(uc);
        return ResponseEntity.status(HttpStatus.OK).build();
    }





}
