package com.epam.practice.oops;

import lombok.ToString;

@ToString
public class DebitCards extends Cards {

	public String category;

	public String getParentProperties() {
		int i =10;
		Cards card = new DebitCards();
		System.out.println("Direct number is: " + card.number);
		Cards detailedCard = card.getCardDetails();
		Cards cardsOver = new Cards("123-234-437", "42/26", "Sai Koushik");
		System.out.println("Non overriden card details are " + cardsOver.getCardDetails());
		number = "4567-3568";
		System.out.println(card.getNumber());
		return detailedCard.number;
	}

	public DebitCards(String category) {
		super("123-234-437", "12/26", "Sai Koushik");
		this.category = category;
	}

	public DebitCards() {
		super("123-234-437", "12/26", "Sai Koushik");
	}
	
	@Override
	public Cards getCardDetails() {
		return new Cards("5678-8765-8645", "07/28", "Koushik");
	}
	

}
