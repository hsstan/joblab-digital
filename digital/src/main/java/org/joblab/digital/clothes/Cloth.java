package org.joblab.digital.clothes;

import java.net.URI;
import java.util.UUID;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class Cloth {
    UUID id;
    String name;
    String shortDescription;
    String longDescription;
    long price;
    URI image;
}
