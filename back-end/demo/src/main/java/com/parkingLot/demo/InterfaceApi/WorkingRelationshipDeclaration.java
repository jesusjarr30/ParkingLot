package com.parkingLot.demo.InterfaceApi;

import com.parkingLot.demo.model.Company;
import com.parkingLot.demo.model.Expenses;
import com.parkingLot.demo.model.WorkingRelationship;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface WorkingRelationshipDeclaration {

    @PostMapping("/add")
    public ResponseEntity<String> addWorkingRelationship(@RequestBody WorkingRelationship e);

    @GetMapping("/getAllExpenses")
    public ResponseEntity<List<WorkingRelationship>>  getAllWorkingRelationship();

    @PutMapping("/EditExpenses/{id}")
    public ResponseEntity<String>  EditExpenses(@PathVariable("id") int id, @RequestBody WorkingRelationship e);

    @DeleteMapping("/DeleteWorkingRelationship/{id}")
    public ResponseEntity<String>  softDeleteWorkingRelationship(int id);
}
