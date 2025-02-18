package com.parkingLot.demo.InterfaceApi;

import com.parkingLot.demo.model.Company;
import com.parkingLot.demo.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface UserDeclaration {

    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestBody User u);

    @GetMapping("/getAllUser")
    public ResponseEntity<List<Company>> getAllUser();

    @PutMapping("/EditUser/{id}")
    public ResponseEntity<String>  EditUser(@PathVariable("id") int id, @RequestBody User u);

    @DeleteMapping("/DeleteEdit/{id}")
    public ResponseEntity<String>  softDelete(int id);
}
