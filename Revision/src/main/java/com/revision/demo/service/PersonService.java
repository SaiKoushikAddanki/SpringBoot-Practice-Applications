package com.revision.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revision.demo.model.Person;
import com.revision.demo.repository.PersonRepository;

@Service
public class PersonService {
	@Autowired
	private PersonRepository personRepository;
	
	public Optional<Person> getPersonRecordById(int id) {
		return personRepository.findById(id);
	}
	
	public List<Person> getAllRecords() {
		List<Person> personList = new ArrayList<>();
		 personRepository.findAll().forEach(personList::add);
		 return personList;
	}
	
	public String insertPersonRecord(Person person) {
		personRepository.save(person);
		return "Person record was successfully saved in DB with ID:" + person.getVotingId();
	}

}
