/**
 * The original code template is from the following source:
 * https://www.youtube.com/watch?v=vtPkZShrvXQ&ab_channel=freeCodeCamp.org
 */

package com.example.demo.service;

import com.example.demo.dao.PersonDao;
import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {
    private final PersonDao personDao;

    @Autowired
    //the @Qualifier serves to distinguish between different instances of PersonDao
    //by changing the name of the qualifier (same as on @Repository in DAO)
    //you can change to another instance
    public PersonService (@Qualifier("stub") PersonDao personDao) {
        this.personDao = personDao;
    }

    public void insertPerson(Person person) {
        personDao.insertPerson(person);
    }

    public Optional<Person> getPersonById(UUID id) {
        return personDao.getPersonById(id);
    }

    public List<Person> getAllPeople() {
        return personDao.getAllPeople();
    }

    public void deletePersonById(UUID id) {
        personDao.deletePersonByID(id);
    }

    public void updatePersonById(UUID id, Person person) {
        this.personDao.updatePersonByID(id, person);
    }
}


