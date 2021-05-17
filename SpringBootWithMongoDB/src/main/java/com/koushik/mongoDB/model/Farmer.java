package com.koushik.mongoDB.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Component
@Document(collection = "farmer")
public class Farmer {

	@Id
	private int id;
	private String name;
	private int numberOfAcers;
	private String category;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumberOfAcers() {
		return numberOfAcers;
	}

	public void setNumberOfAcers(int numberOfAcers) {
		this.numberOfAcers = numberOfAcers;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Farmer [id=" + id + ", name=" + name + ", numberOfAcers=" + numberOfAcers + ", category=" + category
				+ "]";
	}

}
