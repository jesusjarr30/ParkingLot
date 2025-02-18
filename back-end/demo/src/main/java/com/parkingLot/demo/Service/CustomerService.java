package com.parkingLot.demo.Service;

import com.parkingLot.demo.model.Customer;
import com.parkingLot.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;


    public ResponseEntity<String> addCustomer(Customer Customer) {
        customerRepository.save(Customer);
        return new ResponseEntity<>("Se registro la categoria del usuario", HttpStatus.OK);
    }

    public ResponseEntity<List<Customer>> getAllCustomer() {
        List<Customer> CustomerList = customerRepository.findByActiveTrue();
        if(CustomerList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(CustomerList);
    }
    public ResponseEntity<String> EditCustomer(int id,Customer editar) {
        Optional<Customer> ucOptional = customerRepository.findById(id);
        if(!ucOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        customerRepository.save(editar);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    public ResponseEntity<String> softDelete(int id) {
        Optional<Customer>ucOptional = customerRepository.findById(id);
        if(!ucOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        Customer uc = ucOptional.get();
        uc.setActive(false);
        customerRepository.save(uc);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
