package com.parkingLot.demo.controller;

import com.parkingLot.demo.Service.WorkingRelationshipService;
import com.parkingLot.demo.model.WorkingRelationship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class WorkingRelationshipController {

    @Autowired
    private WorkingRelationshipService workingRelationshipService;

    @PostMapping("/add")
    public ResponseEntity<String> adduserCategories(@RequestBody WorkingRelationship wr) {
        return workingRelationshipService.addWorking(wr);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<WorkingRelationship>> getAlluserCategories() {
        return workingRelationshipService.getAllWorking();
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<String> EditUserCategories(@PathVariable("id") int id, @RequestBody WorkingRelationship uc) {
        return workingRelationshipService.Edit(id,uc);
    }

    @DeleteMapping("/softDelete/{id}")
    public ResponseEntity<String> softDelete(@PathVariable("id") int id) {
        return workingRelationshipService.softDelete(id);
    }
}
