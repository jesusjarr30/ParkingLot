package com.parkingLot.demo.InterfaceApi;

import com.parkingLot.demo.model.Company;
import com.parkingLot.demo.model.Crash;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface CrashDeclaration {
    @PostMapping("/add")
    public ResponseEntity<String> addCrash(@RequestBody Crash C);

    @GetMapping("/getAllCrash")
    public ResponseEntity<List<Crash>>  getAllCrash();

    @PutMapping("/EditCrash/{id}")
    public ResponseEntity<String>  EditUserCrash(@PathVariable("id") int id, @RequestBody Crash c);

    @DeleteMapping("/DeleteCrash/{id}")
    public ResponseEntity<String> softDeleteCrash(int id);
}
