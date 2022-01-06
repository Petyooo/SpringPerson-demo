/**
 * The original code template is from the following source:
 * https://www.youtube.com/watch?v=vtPkZShrvXQ&ab_channel=freeCodeCamp.org
 */

package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class Person {

    @NotBlank
    private final String name;
    private final UUID id;

    public Person (@JsonProperty("name") String name, @JsonProperty("id") UUID id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public UUID getId() {
        return id;
    }
}
