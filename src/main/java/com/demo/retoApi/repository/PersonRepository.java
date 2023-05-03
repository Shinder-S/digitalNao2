package com.demo.retoApi.repository;

import com.demo.retoApi.view.PersonView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<PersonView, String> {}