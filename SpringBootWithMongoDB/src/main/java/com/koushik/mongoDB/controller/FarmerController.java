package com.koushik.mongoDB.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.koushik.mongoDB.model.Farmer;
import com.koushik.mongoDB.repository.FarmerRepository;

@RestController
public class FarmerController {
	@Autowired
	private FarmerRepository farmerRepository;

	@PostMapping("/addfarmer")
	private String storeFarmerDetails(@RequestBody Farmer farmer) {
		farmerRepository.save(farmer);
		return "Saved farmer details successfully in DB and ID is: " + farmer.getId();
	}

	@GetMapping("/findAllDetails")
	private List<Farmer> getAllFarmerDetails() {
		return farmerRepository.findAll();
	}

	@GetMapping("/find/{id}")
	private Optional<Farmer> getFarmerById(@PathVariable int id) {
		return farmerRepository.findById(id);
	}

}
