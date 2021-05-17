package com.revision.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "person")
public class Person {

	@Id
	@Column(name = "voterid")
	private int votingId;
	@Column(name = "age")
	private int age;
	@Column(name = "firstname")
	private String firstName;
	@Column(name = "lastname")
	private String lastName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getVotingId() {
		return votingId;
	}

	public void setVotingId(int votingId) {
		this.votingId = votingId;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [votingId=" + votingId + ", age=" + age + ", firstName=" + firstName + ", lastName=" + lastName
				+ "]";
	}

	public Person(int votingId, int age, String firstName, String lastName) {
		super();
		this.votingId = votingId;
		this.age = age;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Person() {
		super();
	}

}
