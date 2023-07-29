package com.koushik.latest.springlatestupdates.practice;

import java.util.Base64;

public class Base64EncodingDecodingPractice {

	public static void main(String[] args) {

		String encoded = Base64.getEncoder().encodeToString("Koushik".getBytes());
		System.out.println(encoded);
		String encodedValue = "S291c2hpaw==";
		String decoded = new String(Base64.getDecoder().decode(encodedValue));
		System.out.println(decoded);

	}

}
