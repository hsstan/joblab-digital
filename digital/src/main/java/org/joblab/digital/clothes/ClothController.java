package org.joblab.digital.clothes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "ClothController")
public class ClothController {

    @Autowired
    ClothService clothService;

    @GetMapping("/clothes")
    public ResponseEntity<List<Cloth>> getClothes(){

        List<Cloth> retList = new ArrayList<>();
        
        for(int i = 0; i < 15; i++){
            retList.add(clothService.getRandomCloth());
        }

        return ResponseEntity.ok(retList);
    }
}
