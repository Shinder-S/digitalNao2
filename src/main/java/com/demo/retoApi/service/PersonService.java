package com.demo.retoApi.service;

import com.demo.retoApi.model.Person;

import java.util.ArrayList;
import java.util.Optional;

public interface PersonService {
    static ArrayList<Person> getAllPerson();
    Optional<Person> getPersonById(long id);
    Person savePerson(Person a);
    boolean detelePerson(long id);
}
