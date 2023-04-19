package com.demo.retoApi.controller;

import com.demo.retoApi.model.Person;
import com.demo.retoApi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class ApiDemo {
    @Autowired
    PersonService personService;

    @GetMapping("/saludar")
    public String saluda(){
        return "Hola bienvenido a nuestra Api en java";

    }

    @GetMapping("/all")
    public ArrayList<Person> getAllPerson(){
       return personService.getAllPerson();
    }

    @GetMapping("/find/{id}")
    public Optional<Person> getPersonById(@PathVariable("id") long id){
        return personService.getPersonById(id);
    }

    @PostMapping("/save")
    public Person savePerson(@RequestBody Person a){
        return personService.savePerson(a);
    }

    @DeleteMapping("/delete/{id}")
    public String deletePersonById(@PathVariable("id") long id){
        if(personService.deletePersonById(id))
            return "Person was deleted successfully";
        else
            return "The person has not been deleted from the database";
    }
}
