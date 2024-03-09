package org.joblab.digital.cars;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.github.javafaker.Faker;

@Service
public class CarService {

    private Faker faker = new Faker(new Locale("it-IT"));
    private List<String> brands = Arrays.asList("BMW", "Audi", "Mercedes", "AlfaRomeo", "Fiat", "Skoda", "Renault");

    private String randomBrand(){
        Random r = new Random();
        return brands.get(r.nextInt(brands.size()));
    }

    private String composeRandomName(String brand){
        return String.format("%s %s %s",
            faker.commerce().color(),
            brand,
            faker.number().numberBetween(1980,2022)
        );
    }

    public Car getRandomCar(){
        Car c = new Car();
        String brand = randomBrand();

        c.setId(UUID.randomUUID());
        c.setName(composeRandomName(brand));
        
        c.setShortDescription(faker.lorem().paragraph());
        c.setLongDescription(String.join("\n", faker.lorem().paragraphs(2)));
        
        c.setPrice(faker.number().numberBetween(1_000, 50_000));

        URI imageUri = URI.create(
            String.format("https://loremflickr.com/%s/%s/cars,%s",
                faker.number().numberBetween(300, 400),
                faker.number().numberBetween(300, 400),
                brand
            )
        );
        c.setImage(imageUri);

        return c;
    }


}
