package com.koushik.docker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

	@GetMapping("/test")
	public String getTestMessage() {
		return "Application is up and running;";
	}

}
