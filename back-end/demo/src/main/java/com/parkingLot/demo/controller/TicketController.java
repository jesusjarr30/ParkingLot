package com.parkingLot.demo.controller;

import com.parkingLot.demo.InterfaceApi.TicketsDeclaration;
import com.parkingLot.demo.Service.TicketsService;
import com.parkingLot.demo.model.Ticket;
import com.parkingLot.demo.repository.TicketsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RequestMapping("/Ticket")
@RestController
public class TicketController implements TicketsDeclaration {

    @Autowired
    private TicketsService ticketsService;

    @Override
    public ResponseEntity<String> addTicke(@RequestBody Ticket t) {
        return ticketsService.addTicket(t);
    }

    @Override
    public ResponseEntity<List<Ticket>> getAllTicket() {
        return ticketsService.getAllTickets();
    }

    @Override
    public ResponseEntity<String> EditTicket(@PathVariable("id") int id, @RequestBody Ticket t) {
        return ticketsService.EditTickets(id,t);
    }

    @Override
    public ResponseEntity<String> softDeleteTicket(@PathVariable("id") int id) {
        return ticketsService.softDeleteTickets(id);
    }
}