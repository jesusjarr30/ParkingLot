package com.parkingLot.demo.Service;

import com.parkingLot.demo.model.LongTermParking;
import com.parkingLot.demo.repository.LongTermParkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LongTermParkingServie {
    @Autowired
    private LongTermParkingRepository longTermParkingRepository;


    public ResponseEntity<String> addLongTermParking(LongTermParking userCategories) {
        longTermParkingRepository.save(userCategories);
        return new ResponseEntity<>("Se registro la categoria del usuario", HttpStatus.OK);
    }

    public ResponseEntity<List<LongTermParking>> getAlluserCategories() {
        List<LongTermParking> userCategoriesList = longTermParkingRepository.findBySoftDeleteFalse();
        if(userCategoriesList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(userCategoriesList);
    }
    public ResponseEntity<String> EditUserCategories(int id,LongTermParking editar) {
        Optional<LongTermParking> ucOptional = longTermParkingRepository.findById(id);
        if(!ucOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        longTermParkingRepository.save(editar);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    public ResponseEntity<String> softDelete(int id) {
        Optional<LongTermParking>ucOptional = longTermParkingRepository.findById(id);
        if(!ucOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        LongTermParking uc = ucOptional.get();
        uc.setSoftDelete(true);
        longTermParkingRepository.save(uc);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
