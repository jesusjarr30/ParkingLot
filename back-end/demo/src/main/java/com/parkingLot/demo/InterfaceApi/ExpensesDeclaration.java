package com.parkingLot.demo.InterfaceApi;

import com.parkingLot.demo.model.Company;
import com.parkingLot.demo.model.Expenses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ExpensesDeclaration {

    @PostMapping("/add")
    public ResponseEntity<String> addExpenses(@RequestBody Expenses e);

    @GetMapping("/getAllExpenses")
    public ResponseEntity<List<Expenses>>  getAllExpenses();

    @PutMapping("/EditExpenses/{id}")
    public ResponseEntity<String>  EditExpenses(@PathVariable("id") int id, @RequestBody Expenses e);

    @DeleteMapping("/DeleteExpenses/{id}")
    public ResponseEntity<String>  softDelete(int id);

}
