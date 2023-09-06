package com.project.billing;

public class ElectricityBill {
	
	private int prevReading;
	private int presReading;
	private float asserts;
	private float credits;
	public ElectricityBill(int prevReading, int presReading, float asserts, float credits) {
		super();
		this.prevReading = prevReading;
		this.presReading = presReading;
		this.asserts = asserts;
		this.credits = credits;
	}
	public int getPrevReading() {
		return prevReading;
	}
	public void setPrevReading(int prevReading) {
		this.prevReading = prevReading;
	}
	public int getPresReading() {
		return presReading;
	}
	public void setPresReading(int presReading) {
		this.presReading = presReading;
	}
	public float getAsserts() {
		return asserts;
	}
	public void setAsserts(float asserts) {
		this.asserts = asserts;
	}
	public float getCredits() {
		return credits;
	}
	public void setCredits(float credits) {
		this.credits = credits;
	}
	
}
