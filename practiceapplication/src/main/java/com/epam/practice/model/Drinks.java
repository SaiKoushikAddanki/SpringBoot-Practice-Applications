package com.epam.practice.model;

public enum Drinks {

	THUMSUP("Soft drink"), SPRITE("soft drink"), PEPSI("soft drink");

	private String action;

	Drinks(String val) {
		this.action = val;
	}

	public String getAction() {
		return this.action;
	}

}
