package com.parkingLot.demo.Service;

import com.parkingLot.demo.InterfaceApi.UserCategoriesDeclaration;
import com.parkingLot.demo.model.Parking;
import com.parkingLot.demo.model.UserCategories;
import com.parkingLot.demo.repository.UserCategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Service
public class UserCategoriesService  {
    @Autowired
    private UserCategoriesRepository userCategoriesRepository;

    public ResponseEntity<String> adduserCategories(UserCategories userCategories) {
        userCategoriesRepository.save(userCategories);
        return new ResponseEntity<>("Se registro la categoria del usuario", HttpStatus.OK);
    }

    public ResponseEntity<List<UserCategories>> getAlluserCategories() {
        List<UserCategories> userCategoriesList = userCategoriesRepository.findBySoftDeleteFalse();
        if(userCategoriesList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(userCategoriesList);
    }
    public ResponseEntity<List<UserCategories>> EditUserCategories(int id,UserCategories editar) {
        Optional<UserCategories> ucOptional = userCategoriesRepository.findById(id);
        if(!ucOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        UserCategories uc=ucOptional.get();
        uc.setRole(editar.getRole());
        uc.setSoftDelete(editar.isSoftDelete());
        userCategoriesRepository.save(uc);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    public ResponseEntity<String> softDelete(int id) {
        Optional<UserCategories>ucOptional = userCategoriesRepository.findById(id);
        if(!ucOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        UserCategories uc = ucOptional.get();
        uc.setSoftDelete(true);
        userCategoriesRepository.save(uc);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
