package com.parkingLot.demo.Service;

import com.parkingLot.demo.model.Invoices;
import com.parkingLot.demo.repository.InvoicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoicesService {
    @Autowired
    private InvoicesRepository invoicesRepository;

    public ResponseEntity<String> addInvoices(Invoices invoices) {
        invoicesRepository.save(invoices);
        return new ResponseEntity<>("Se registro la categoria del usuario", HttpStatus.OK);
    }

    public ResponseEntity<List<Invoices>> getAllInvoices() {
        List<Invoices> InvoicesList = invoicesRepository.findBySoftDeleteFalse();
        if(InvoicesList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(InvoicesList);
    }
    public ResponseEntity<List<Invoices>> EditInvoices(int id,Invoices editar) {
        Optional<Invoices> ucOptional = invoicesRepository.findById(id);
        if(!ucOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        invoicesRepository.save(editar);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    public ResponseEntity<String> softDelete(int id) {
        Optional<Invoices>ucOptional = invoicesRepository.findById(id);
        if(!ucOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        Invoices uc = ucOptional.get();
        uc.setSoftDelete(true);
        invoicesRepository.save(uc);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
