package org.joblab.digital.techs;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.github.javafaker.Faker;

@Service
public class TechService {

    private Faker faker = new Faker(new Locale("it-IT"));
    private List<String> techs = Arrays.asList("computer","laptop","notebook","keyboard","mouse","screen","desktop");

    private String randomType(){
        Random r = new Random();
        return techs.get(r.nextInt(techs.size()));
    }

    private String composeRandomName(String type){
        return String.format("%s %s",
            faker.commerce().color(),
            type
        );
    }

    public Tech getRandomTechs(){
        Tech c = new Tech();
        c.setId(UUID.randomUUID());

        String type = randomType();
        c.setName(composeRandomName(type));

        c.setShortDescription(faker.lorem().paragraph());
        c.setLongDescription(String.join("\n", faker.lorem().paragraphs(2)));
        
        c.setPrice(faker.number().numberBetween(150L, 500L));

        URI imageUri = URI.create(
            String.format("https://picsum.photos/%s/%s",
                faker.number().numberBetween(300, 400),
                faker.number().numberBetween(300, 400)
            )
        );
        c.setImage(imageUri);

        return c;
    }


}
