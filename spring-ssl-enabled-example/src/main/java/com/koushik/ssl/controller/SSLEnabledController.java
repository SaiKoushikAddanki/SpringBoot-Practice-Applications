package com.koushik.ssl.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SSLEnabledController {

	@GetMapping("/test")
	public String getTheStringForTest() {
		return "Hi There you are recieving message from the HTTPS enabled endpoint";
	}
}
