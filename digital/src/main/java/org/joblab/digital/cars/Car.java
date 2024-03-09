package org.joblab.digital.cars;

import java.net.URI;
import java.util.UUID;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class Car {
    UUID id;
    String name;
    String shortDescription;
    String longDescription;
    int price;
    URI image;
}
