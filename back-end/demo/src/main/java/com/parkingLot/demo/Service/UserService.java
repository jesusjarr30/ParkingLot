package com.parkingLot.demo.Service;

import com.parkingLot.demo.model.User;
import com.parkingLot.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<String> add(User userCategories) {
        userRepository.save(userCategories);
        return new ResponseEntity<>("Se registro la categoria del usuario", HttpStatus.OK);
    }

    public ResponseEntity<List<User>> getAll() {
        List<User> userCategoriesList = userRepository.findBySoftDeleteFalse();
        if(userCategoriesList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(userCategoriesList);
    }
    public ResponseEntity<String> Edit(int id,User editar) {
        Optional<User> ucOptional = userRepository.findById(id);
        if(!ucOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        userRepository.save(editar);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    public ResponseEntity<String> softDelete(int id) {
        Optional<User>ucOptional = userRepository.findById(id);
        if(!ucOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        User uc = ucOptional.get();
        uc.setSoftDelete(true);
        userRepository.save(uc);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
