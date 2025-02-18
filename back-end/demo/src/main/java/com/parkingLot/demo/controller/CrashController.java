package com.parkingLot.demo.controller;

import com.parkingLot.demo.Service.CrashService;
import com.parkingLot.demo.model.Crash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/crash")
@RestController
public class CrashController {
    @Autowired
    private CrashService crashService;

    @PostMapping("/add")
    public ResponseEntity<String> addCrash(@RequestBody Crash Crash) {
        return crashService.addCrash(Crash);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Crash>> getAllCrash() {
        return crashService.getCrash();
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<List<Crash>> EditCrash(@PathVariable("id") int id, @RequestBody Crash uc) {
        return crashService.EditCrash(id,uc);
    }

    @DeleteMapping("/softDelete/{id}")
    public ResponseEntity<String> softDelete(@PathVariable("id") int id) {
        return crashService.softDelete(id);
    }
    
}
