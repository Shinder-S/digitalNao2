package com.demo.retoApi.service;

import com.demo.retoApi.model.Person;

import java.util.ArrayList;
import java.util.Optional;

public interface PersonService {
    ArrayList<Person> getAllPerson();
    Optional<Person> getPersonById(long id);
    Person savePerson(Person a);
    boolean deletePersonById(long id);
}
