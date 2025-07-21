package com.example.exception_handling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ExceptionHandlingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExceptionHandlingApplication.class, args);
	}

}
