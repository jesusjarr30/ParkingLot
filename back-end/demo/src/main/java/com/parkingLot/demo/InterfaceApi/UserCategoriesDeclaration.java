package com.parkingLot.demo.InterfaceApi;

import com.parkingLot.demo.model.Parking;
import com.parkingLot.demo.model.UserCategories;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface UserCategoriesDeclaration {

    @PostMapping("/userCategories")
    public ResponseEntity<String> adduserCategories(@RequestBody UserCategories userCategories);

    @GetMapping("/getAllParking")
    public ResponseEntity<List<UserCategories>>  getAlluserCategories();

    @PutMapping("/EditUserCategories/{uc}")
    public ResponseEntity<List<UserCategories>>  EditUserCategories(@PathVariable("id") int id, @RequestBody UserCategories uc);

    @DeleteMapping("/EditUserCategories/{id}")
    public ResponseEntity<String>  softDelete(int id);
}
