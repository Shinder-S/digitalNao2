package com.demo.retoApi.service;

import com.demo.retoApi.model.Person;
import com.demo.retoApi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public Iterable<Person> getAllUsers() {
        return personRepository.findAll();
    }

    public Person addPerson(Person person) {
        return personRepository.save(person);
    }

    public void addPerson() {
    }
}

