package com.demo.retoApi.controller;
import com.demo.retoApi.model.Person;
import com.demo.retoApi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/requests")
public class PersonController {
    @Autowired
    private PersonService personServiceImpl;

    @GetMapping(path = "", produces = { "application/json" })
    public ResponseEntity<ArrayList<Person>> getPerson() {

        ArrayList<Person> personList = this.personServiceImpl.getPersonViewList();
        if (!personList.isEmpty()) {
            return new ResponseEntity<>(personList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(personList, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/{id}", produces = { "application/json" })
    public ResponseEntity<Person> getPerson(@PathVariable("id") String id){

        Person person = new Person();

        if(id!=null){
            person = this.personServiceImpl.getPersonView(id);
            return new ResponseEntity<>(person, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(person, HttpStatus.NOT_FOUND);
        }
    }
}
