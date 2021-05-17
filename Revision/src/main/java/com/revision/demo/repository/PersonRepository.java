package com.revision.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revision.demo.model.Person;
@Repository
public interface PersonRepository extends JpaRepository<Person, Integer>{

	
}
