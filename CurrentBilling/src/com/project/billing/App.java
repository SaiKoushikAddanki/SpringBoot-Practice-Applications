package com.project.billing;

public class App {

	public static void main(String[] args) {
		ElectricityBill eb = new ElectricityBill(22418, 22716, 452.00f, 0);
		BillGenerator bill = new BillGenerator(eb);
		bill.nextAmount();
		System.out.println(bill.getAmount());
	}

}
