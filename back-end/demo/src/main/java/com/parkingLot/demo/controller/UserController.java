package com.parkingLot.demo.controller;
import com.parkingLot.demo.Service.UserService;


import com.parkingLot.demo.model.User;
import com.parkingLot.demo.model.WorkingRelationship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/User")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody User wr) {
        return userService.add(wr);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<User>> getAll() {
        return userService.getAll();
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<String> Edit(@PathVariable("id") int id, @RequestBody User uc) {
        return userService.Edit(id,uc);
    }

    @DeleteMapping("/softDelete/{id}")
    public ResponseEntity<String> softDelete(@PathVariable("id") int id) {
        return userService.softDelete(id);
    }

}
