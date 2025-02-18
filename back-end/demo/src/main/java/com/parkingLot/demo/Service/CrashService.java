package com.parkingLot.demo.Service;

import com.parkingLot.demo.model.Crash;
import com.parkingLot.demo.repository.CrashRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CrashService {
    @Autowired
    private CrashRepository crashRepository;


    public ResponseEntity<String> addCrash(Crash userCategories) {
        crashRepository.save(userCategories);
        return new ResponseEntity<>("Se registro la categoria del usuario", HttpStatus.OK);
    }

    public ResponseEntity<List<Crash>> getCrash() {
        List<Crash> userCategoriesList = crashRepository.findBySoftDeleteFalse();
        if(userCategoriesList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(userCategoriesList);
    }
    public ResponseEntity<List<Crash>> EditCrash(int id,Crash editar) {
        Optional<Crash> ucOptional = crashRepository.findById(id);
        if(!ucOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        Crash uc=ucOptional.get();

        crashRepository.save(editar);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    public ResponseEntity<String> softDelete(int id) {
        Optional<Crash>ucOptional = crashRepository.findById(id);
        if(!ucOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        Crash uc = ucOptional.get();
        uc.setSoftDelete(true);
        crashRepository.save(uc);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
