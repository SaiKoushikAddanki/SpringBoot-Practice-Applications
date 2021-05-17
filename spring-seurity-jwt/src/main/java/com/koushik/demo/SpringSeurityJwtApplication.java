package com.koushik.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.koushik.demo.configuration.ConfigurationForSecurity;

@SpringBootApplication
@Import(value = ConfigurationForSecurity.class)
public class SpringSeurityJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSeurityJwtApplication.class, args);
	}

}
