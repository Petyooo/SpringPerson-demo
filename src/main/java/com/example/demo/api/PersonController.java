/**
 * The original code template is from the following source:
 * https://www.youtube.com/watch?v=vtPkZShrvXQ&ab_channel=freeCodeCamp.org
 */

package com.example.demo.api;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {
    private final PersonService service;

    @Autowired
    //here you don't have a qualifier. I'm assuming
    //it's because the intent is to have only one service at the moment
    public PersonController (PersonService service) {
        this.service = service;
    }

    @PostMapping
    //serves as a post request
    //take the request body and place it inside of this person
    public void addPerson(@Valid @NonNull @RequestBody Person person) {
        this.service.insertPerson(person);
    }

    @GetMapping
    public List<Person> getAllPeople() {
        return this.service.getAllPeople();
    }

    @GetMapping(path = "{id}")
    //note- this one should not be optional, you either return the person or null
    public Person getPersonById(@PathVariable("id") UUID id) {
        return this.service.getPersonById(id).orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deletePersonById(@PathVariable("id") UUID id) {
        this.service.deletePersonById(id);
    }

    @PutMapping(path = "{id}")
    public void updatePersonById(@PathVariable("id") UUID id,@Valid @NonNull @RequestBody Person person) {
        this.service.updatePersonById(id, person);
    }
}
