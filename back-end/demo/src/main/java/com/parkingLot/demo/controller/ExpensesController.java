package com.parkingLot.demo.controller;

import com.parkingLot.demo.InterfaceApi.ExpensesDeclaration;
import com.parkingLot.demo.Service.ExpensesService;
import com.parkingLot.demo.model.Expenses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/Expenses")
@RestController
public class ExpensesController implements ExpensesDeclaration {

    private ExpensesService expensesService;

    @PostMapping("/addExpenses")
    @Override
    public ResponseEntity<String> addExpenses(@RequestBody Expenses e) {
        return expensesService.addExpenses(e);
    }

    @GetMapping("/getExpenses")
    @Override
    public ResponseEntity<List<Expenses>> getAllExpenses() {
        return expensesService.getAllExpenses();
    }

    @PutMapping("/EditExpenses/{id}")
    @Override
    public ResponseEntity<String> EditExpenses(@PathVariable("id") int id, @RequestBody Expenses e) {
        return expensesService.EditExpenses(id,e);
    }
    @DeleteMapping("/softDelete/{id}")
    @Override
    public ResponseEntity<String> softDelete(@PathVariable("id") int id) {
        return expensesService.softDelete(id);
    }
}
