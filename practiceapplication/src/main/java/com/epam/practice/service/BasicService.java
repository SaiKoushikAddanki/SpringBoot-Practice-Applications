package com.epam.practice.service;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BasicService {

	public String getResponse() {
		log.info("Entered into the service method");
		return "sample service returned";
	}
}
