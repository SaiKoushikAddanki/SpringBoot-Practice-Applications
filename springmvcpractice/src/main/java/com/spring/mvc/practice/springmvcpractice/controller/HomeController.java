package com.spring.mvc.practice.springmvcpractice.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping(value="/")
	public String test(HttpServletResponse response) throws IOException{
		System.out.println("Entered into controller");
		return "index";
	}
}
