/**
 * The original code template is from the following source:
 * https://www.youtube.com/watch?v=vtPkZShrvXQ&ab_channel=freeCodeCamp.org
 */

package com.example.demo.dao;

import com.example.demo.model.Person;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository("stub")
public class StubDataAccessService implements PersonDao {
    // In Memory DB
    private static List<Person> peopleDB = new ArrayList<>();

    @Override
    public void insertPerson (UUID id, Person person) {
        // because the properties of a person are final, hence immutable (no setters)
        // if you send in a person via a post method and its id is null
        // then the id cannot be set. This is why you have to make a new person object
        peopleDB.add(new Person(person.getName(), id));
    }

    @Override
    public Optional<Person> getPersonById (UUID id) {
        Optional<Person> person = peopleDB.stream().filter(p -> p.getId().equals(id)).findFirst();
        return person;
    }

    @Override
    public Optional<Person> getPersonByName(String name) {
        Optional<Person> person = peopleDB.stream().filter(p -> p.getName().equals(name)).findFirst();
        return person;
    }

    @Override
    public List<Person> getAllPeople() {
        return peopleDB;
    }

    @Override
    public void deletePersonByID (UUID id) {
        Optional<Person> person = getPersonById(id); //use the existing methods you already wrote!!!
        if(person.isPresent()) {
            peopleDB.remove(person.get());
        }
    }

    @Override
    public void updatePersonByID (UUID id, Person person) {
        // with the previous code I was not keeping the position of the person in the list
        // I was adding them at the end
        Optional<Person> existingPerson = getPersonById(id);
        if(existingPerson.isPresent()) {
            int index = peopleDB.indexOf(existingPerson.get());
            peopleDB.set(index, new Person(person.getName(), id));
        }
    }

}


