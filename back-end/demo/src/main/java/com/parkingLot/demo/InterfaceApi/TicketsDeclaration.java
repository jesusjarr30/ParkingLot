package com.parkingLot.demo.InterfaceApi;

import com.parkingLot.demo.model.Company;
import com.parkingLot.demo.model.Expenses;
import com.parkingLot.demo.model.Ticket;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface TicketsDeclaration {

    @PostMapping("/add")
    public ResponseEntity<String> addTicke(@RequestBody Ticket t);

    @GetMapping("/getAllTicket")
    public ResponseEntity<List<Ticket>>  getAllTicket();

    @PutMapping("/EditTicket/{id}")
    public ResponseEntity<String>  EditTicket(@PathVariable("id") int id, @RequestBody Ticket t);

    @DeleteMapping("/DeleteTicket/{id}")
    public ResponseEntity<String>  softDeleteTicket(int id);
}
