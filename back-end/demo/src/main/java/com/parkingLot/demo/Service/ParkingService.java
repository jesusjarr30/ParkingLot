package com.parkingLot.demo.Service;

import com.parkingLot.demo.model.Parking;
import com.parkingLot.demo.model.Prices;
import com.parkingLot.demo.repository.ParkingRepository;
import com.parkingLot.demo.repository.PricesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParkingService {
    @Autowired
    private ParkingRepository parkingRepository;

    public ResponseEntity<String> addParking(Parking parking) {
        parkingRepository.save(parking);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<List<Parking>> getParking() {
        List<Parking> userCategoriesList = parkingRepository.findBySoftDeleteFalse();
        if(userCategoriesList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(userCategoriesList);
    }
    public ResponseEntity<List<Parking>> EditParking(int id,Parking editar) {
        Optional<Parking> ucOptional = parkingRepository.findById(id);
        if(!ucOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        Parking uc=ucOptional.get();
        parkingRepository.save(editar);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    public ResponseEntity<String> softDeleteParking(int id) {
        Optional<Parking>ucOptional = parkingRepository.findById(id);
        if(!ucOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        Parking uc = ucOptional.get();
        uc.setSoftDelete(true);
        parkingRepository.save(uc);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    public ResponseEntity<String> getFreeSpace(int id){
        return null;
    }

    public int getTotalAvailableSpaces(int id) {
        return parkingRepository.getTotalAvailableSpaces(id);
    }
}
