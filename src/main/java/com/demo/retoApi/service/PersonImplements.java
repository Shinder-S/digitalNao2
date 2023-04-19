package com.demo.retoApi.service;

import com.demo.retoApi.model.Person;
import com.demo.retoApi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class PersonImplements implements PersonService{
    @Autowired
    PersonRepository personRepository;
    @Override
    public ArrayList<Person> getAllPerson() {
        return (ArrayList<Person>) personRepository.findAll();
    }

    @Override
    public Optional<Person> getPersonById(long id) {
        return personRepository.findById(id);
    }

    @Override
    public Person savePerson(Person a) {
        return personRepository.save(a);
    }

    @Override
    public boolean deletePersonById(long id) {
        try{
            Optional<Person> a = getPersonById(id);
            personRepository.delete(a.get());
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
