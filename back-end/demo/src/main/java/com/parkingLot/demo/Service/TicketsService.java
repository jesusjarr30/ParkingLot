package com.parkingLot.demo.Service;

import com.parkingLot.demo.model.Ticket;
import com.parkingLot.demo.repository.TicketsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketsService {
    @Autowired
    private TicketsRepository ticketsRepository;


    public ResponseEntity<String> addTicket(Ticket userCategories) {
        ticketsRepository.save(userCategories);
        return new ResponseEntity<>("Se registro la categoria del usuario", HttpStatus.OK);
    }

    public ResponseEntity<List<Ticket>> getAllTickets() {
        List<Ticket> userCategoriesList = ticketsRepository.findBySoftDeleteFalse();
        if(userCategoriesList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(userCategoriesList);
    }
    public ResponseEntity<String> EditTickets(int id,Ticket editar) {
        Optional<Ticket> ucOptional = ticketsRepository.findById(id);
        if(!ucOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        ticketsRepository.save(editar);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    public ResponseEntity<String> softDeleteTickets(int id) {
        Optional<Ticket>ucOptional = ticketsRepository.findById(id);
        if(!ucOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        Ticket uc = ucOptional.get();
        uc.setSoftDelete(true);
        ticketsRepository.save(uc);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
