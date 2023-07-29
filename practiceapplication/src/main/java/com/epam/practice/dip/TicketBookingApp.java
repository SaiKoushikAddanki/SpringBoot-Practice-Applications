package com.epam.practice.dip;

public class TicketBookingApp {

	private Cards cards;
	
	public TicketBookingApp(Cards cards) {
		this.cards = cards;
	}
	
	public void doPayment(int noOfTickets, int amount) {
		cards.doTransaction(amount);
	}
	
	public static void main(String[] args) {
		DebitCard debitCard = new DebitCard();
		TicketBookingApp ticketApp = new TicketBookingApp(debitCard);
		ticketApp.doPayment(4,5000);
	}
}

