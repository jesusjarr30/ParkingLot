package com.parkingLot.demo.Service;

import com.parkingLot.demo.model.Expenses;
import com.parkingLot.demo.repository.ExpensesRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpensesService {

    private ExpensesRepository expensesRepository;
    
    public ResponseEntity<String> addExpenses(Expenses Expenses) {
        expensesRepository.save(Expenses);
        return new ResponseEntity<>("Se registro la categoria del usuario", HttpStatus.OK);
    }

    public ResponseEntity<List<Expenses>> getAllExpenses() {
        List<Expenses> ExpensesList = expensesRepository.findBySoftDeleteFalse();
        if(ExpensesList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(ExpensesList);
    }
    public ResponseEntity<String> EditExpenses(int id,Expenses editar) {
        Optional<Expenses> ucOptional = expensesRepository.findById(id);
        if(!ucOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        expensesRepository.save(editar);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    public ResponseEntity<String> softDelete(int id) {
        Optional<Expenses>ucOptional = expensesRepository.findById(id);
        if(!ucOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        Expenses uc = ucOptional.get();
        uc.setSoftDelete(true);
        expensesRepository.save(uc);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
