package com.koushik.mail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.koushik.mail.model.EmailRequest;
import com.koushik.mail.model.EmailResponse;
import com.koushik.mail.service.EmailService;

@RestController
public class Triggers {
	
	@Autowired
	private EmailService emailService;
	
	@PostMapping("/sendEmail")
	public EmailResponse sendEmailWithDetailsProvided(@RequestBody EmailRequest request) {
		return emailService.send(request);
		
	}
	
	@GetMapping("/welcome")
	public String welcomeMessage() {
		return "Welcome to the first practise application of public exposed spring boot application by ASK";
	}

}
