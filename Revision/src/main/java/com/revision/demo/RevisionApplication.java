package com.revision.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import com.revision.demo.controller.EntryController;

@SpringBootApplication
public class RevisionApplication {

	public static void main(String[] args) {
		SpringApplication.run(RevisionApplication.class, args);
	}

}
