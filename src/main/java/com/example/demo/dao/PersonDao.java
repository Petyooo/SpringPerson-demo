/**
 * The original code template is from the following source:
 * https://www.youtube.com/watch?v=vtPkZShrvXQ&ab_channel=freeCodeCamp.org
 */

package com.example.demo.dao;

import com.example.demo.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {

    void insertPerson(UUID id, Person person);

    default void insertPerson(Person person) {
        UUID new_id = UUID.randomUUID();
        insertPerson(new_id, person);
    };

    Optional<Person> getPersonById(UUID id);

    Optional<Person> getPersonByName(String name);

    List<Person> getAllPeople();

    void deletePersonByID(UUID id);

    void updatePersonByID(UUID id, Person person);
}
