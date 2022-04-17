package com.ask.solutions.elastic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ask.solutions.elastic.responsemodel.ApiResponse;

public interface IESController {
	
	@GetMapping("/response")
	public ApiResponse<String> getBookingDetails();
	
	@GetMapping("/response/{name}")
	public ApiResponse<String> getBankDetaiilsByFirstName(@PathVariable String name);

}
