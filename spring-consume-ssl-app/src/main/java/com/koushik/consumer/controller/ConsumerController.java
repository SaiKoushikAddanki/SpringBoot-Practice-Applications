package com.koushik.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {
	
	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/response")
	public String getResponseFromSSLApplication() {
		return restTemplate.getForEntity("https://localhost:7071/test", String.class).getBody();
	}
}
