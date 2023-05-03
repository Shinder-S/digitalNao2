package com.demo.retoApi.service;

import com.demo.retoApi.model.Person;
import java.util.ArrayList;

public interface PersonService {
    Person getPersonView(String id);
    ArrayList<Person> getPersonViewList();
}
