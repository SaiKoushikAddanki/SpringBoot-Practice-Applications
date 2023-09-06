package com.project.billing;

public class BillGenerator {

	private ElectricityBill eb;
	private float amount;

	private static int fixedAmount = 210;
	private static int taxPercentage = 8;
	private static float f30u = 3.75f;
	private static float n70u = 5.20f;
	private static float n100u = 6.75f;
	private static float a100u = 7.80f;
	private static float FACCharges = 0.12f;

	public BillGenerator(ElectricityBill ed) {
		super();
		this.eb = ed;
	}

	public ElectricityBill getEd() {
		return eb;
	}

	public void setEd(ElectricityBill ed) {
		this.eb = ed;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public int unitsConsumed() {
		return eb.getPresReading() - eb.getPrevReading();
	}

	public void nextAmount() {
		int unitsConsumed = unitsConsumed();
		float FAC = unitsConsumed * FACCharges;
		float taxAmount =0.0f;
		float netAmount = 0;
		if (unitsConsumed <= 30) {
			netAmount = unitsConsumed * f30u;
		} else if (unitsConsumed > 30) {
			netAmount = 30 * f30u;
			unitsConsumed = unitsConsumed - 30;
			if (unitsConsumed <= 70) {
				netAmount = netAmount + (unitsConsumed * n70u);
			} else if (unitsConsumed > 70) {
				netAmount =  netAmount +(70* n70u);
				unitsConsumed = unitsConsumed - 70;
				if (unitsConsumed <= 100) {
					netAmount = netAmount + (unitsConsumed * n100u);
				} else if (unitsConsumed > 100) {
					netAmount = netAmount + (100 * n100u);
					unitsConsumed = unitsConsumed - 100;
					if (unitsConsumed > 0) {
						netAmount = netAmount + (unitsConsumed * a100u);
					}
				}
			}
		}
		taxAmount = percentageCalculation(netAmount+fixedAmount + FAC);
		this.setAmount(fixedAmount + netAmount + FAC + taxAmount + eb.getAsserts() - eb.getCredits());
	}

	private float percentageCalculation(float netAmount) {
		return (netAmount*taxPercentage)/100f;
	}

}
