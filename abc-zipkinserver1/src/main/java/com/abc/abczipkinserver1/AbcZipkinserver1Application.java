package com.abc.abczipkinserver1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class AbcZipkinserver1Application {

	public static void main(String[] args) {
		SpringApplication.run(AbcZipkinserver1Application.class, args);
	}

	Logger logger = LoggerFactory.getLogger(AbcZipkinserver1Application.class);


	@RequestMapping("/") 
	public String home() { 
		logger.info("you called home"); 
		return "Hello World"; 
	} 
}
