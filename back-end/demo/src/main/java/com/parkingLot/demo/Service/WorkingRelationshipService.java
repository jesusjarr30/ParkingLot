package com.parkingLot.demo.Service;

import com.parkingLot.demo.model.User;
import com.parkingLot.demo.model.WorkingRelationship;
import com.parkingLot.demo.repository.WorkingRelationshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public class WorkingRelationshipService {
    @Autowired
    private WorkingRelationshipRepository workingRelationshipRepository;

    public ResponseEntity<String> addWorking(WorkingRelationship  wr) {
        workingRelationshipRepository.save(wr);
        return new ResponseEntity<>("Se registro la categoria del usuario", HttpStatus.OK);
    }

    public ResponseEntity<List<WorkingRelationship>> getAllWorking() {
        List<WorkingRelationship> userCategoriesList = workingRelationshipRepository.findBySoftDeleteFalse();
        if(userCategoriesList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(userCategoriesList);
    }
    public ResponseEntity<String> Edit(int id,WorkingRelationship editar) {
        Optional<WorkingRelationship> ucOptional = workingRelationshipRepository.findById(id);
        if(!ucOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        workingRelationshipRepository.save(editar);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    public ResponseEntity<String> softDelete(int id) {
        Optional<WorkingRelationship>ucOptional = workingRelationshipRepository.findById(id);
        if(!ucOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        WorkingRelationship uc = ucOptional.get();
        uc.setSoftDelete(true);
        workingRelationshipRepository.save(uc);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
