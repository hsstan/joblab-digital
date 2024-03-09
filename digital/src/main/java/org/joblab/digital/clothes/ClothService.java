package org.joblab.digital.clothes;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.github.javafaker.Faker;

@Service
public class ClothService {

    private Faker faker = new Faker(new Locale("it-IT"));
    private List<String> types = Arrays.asList("shirt","skirt","gloves","trousers","jeans","belt","shoes");

    private String randomType(){
        Random r = new Random();
        return types.get(r.nextInt(types.size()));
    }

    private String composeRandomName(String type){
        return String.format("%s %s",
            faker.commerce().color(),
            type
        );
    }

    public Cloth getRandomCloth(){
        Cloth c = new Cloth();
        c.setId(UUID.randomUUID());

        String type = randomType();
        c.setName(composeRandomName(type));

        c.setShortDescription(faker.lorem().paragraph());
        c.setLongDescription(String.join("\n", faker.lorem().paragraphs(2)));
        
        c.setPrice(faker.number().numberBetween(10, 150));

        URI imageUri = URI.create(
            String.format("https://loremflickr.com/%s/%s/clothes,%s",
                faker.number().numberBetween(300, 400),
                faker.number().numberBetween(300, 400),
                type
            )
        );
        c.setImage(imageUri);

        return c;
    }


}
