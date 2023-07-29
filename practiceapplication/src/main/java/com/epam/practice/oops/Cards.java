package com.epam.practice.oops;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@ToString
@AllArgsConstructor
@Data
public class Cards {

	public String number;
	private String expiry;
	private String name;
	
	
	
	protected Cards getCardDetails() {
		return new Cards("1234-4678-9875", "12/26", "Sai Koushik Addanki");
		
	}

}
