package com.example.servingwebcontent.repository;

import com.example.servingwebcontent.domain.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Integer> {

}
