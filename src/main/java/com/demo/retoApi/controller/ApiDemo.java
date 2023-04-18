package com.demo.retoApi.controller;

import com.demo.retoApi.model.Person;
import com.demo.retoApi.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("api")
public class ApiDemo {
    @GetMapping("/saludar")
    public String saluda(){
        return "Hola bienvenido a nuestra Api en java";

    }

    @GetMapping("/all")
    public ArrayList<Person> getAllPerson(){
        PersonService.getAllPerson();
    }

}
