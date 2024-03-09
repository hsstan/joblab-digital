package org.joblab.digital.techs;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "TechController")
public class TechController {

    @Autowired
    TechService techService;

    @GetMapping("/techs")
    public ResponseEntity<List<Tech>> getClothes(){

        List<Tech> retList = new ArrayList<>();
        
        for(int i = 0; i < 15; i++){
            retList.add(techService.getRandomTechs());
        }

        return ResponseEntity.ok(retList);
    }
}
