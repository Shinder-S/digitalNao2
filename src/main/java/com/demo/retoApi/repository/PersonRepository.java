package com.demo.retoApi.repository;

import com.demo.retoApi.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {
}
