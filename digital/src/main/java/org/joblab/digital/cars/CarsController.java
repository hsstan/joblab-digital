package org.joblab.digital.cars;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/cars")
public class CarsController {

    @Autowired
    CarService carService;

    @GetMapping("/")
    public ResponseEntity<List<Car>> getCars(){

        List<Car> retList = new ArrayList<>();
        
        for(int i = 0; i < 15; i++){
            retList.add(carService.getRandomCar());
        }

        return ResponseEntity.ok(retList);
    }
}
