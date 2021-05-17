package com.revision.demo.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revision.demo.model.Person;
import com.revision.demo.service.PersonService;

@RestController
@RequestMapping("/api")
public class EntryController {
	
	Logger logger = LoggerFactory.getLogger(EntryController.class);
	
	@Autowired
	PersonService personService;

	@GetMapping("/welcome/{name}")
	public String welcome(@PathVariable String name) {
		return "welcome to the portal Mr." + name;
	}

	@GetMapping("/siteDetails")
	public String getSiteDetails() {
		return "This Rest site is for spring security purpose.";
	}

	@GetMapping("/getPerson}")
	public String getPersonDetails() {
		return "The person details are" + new Person(43, 23, "koushik", "sai").toString();
	}

	@GetMapping("/person/{id}")
	public Optional<Person> getPersonTableData(@PathVariable int id) {
		return personService.getPersonRecordById(id);
	}
	
	@GetMapping("/allpersonrecords")
	public List<Person> getPersonTableData() {
		return personService.getAllRecords();
	}
	
	@PostMapping("/addPerson")
	public String insertPersonRecord(@RequestBody Person person) {
		return personService.insertPersonRecord(person);
	}

}
