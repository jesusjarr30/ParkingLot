package com.parkingLot.demo.controller;

import com.parkingLot.demo.InterfaceApi.UserCategoriesDeclaration;
import com.parkingLot.demo.Service.UserCategoriesService;
import com.parkingLot.demo.model.UserCategories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/UserCategories")
@RestController
public class UserCategoriesController implements UserCategoriesDeclaration{
    @Autowired
    private UserCategoriesService userCategoriesDeclaration;

    @PostMapping("/add")
    public ResponseEntity<String> adduserCategories(@RequestBody UserCategories userCategories) {
        return userCategoriesDeclaration.adduserCategories(userCategories);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<UserCategories>> getAlluserCategories() {
        return userCategoriesDeclaration.getAlluserCategories();
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<List<UserCategories>> EditUserCategories(@PathVariable("id") int id, @RequestBody UserCategories uc) {
        return userCategoriesDeclaration.EditUserCategories(id,uc);
    }

    @DeleteMapping("/softDelete/{id}")
    public ResponseEntity<String> softDelete(@PathVariable("id") int id) {
        return userCategoriesDeclaration.softDelete(id);
    }

}
