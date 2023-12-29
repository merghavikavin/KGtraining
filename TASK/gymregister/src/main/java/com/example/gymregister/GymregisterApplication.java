package com.example.gymregister;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@SpringBootApplication
@OpenAPIDefinition
public class GymregisterApplication {

	public static void main(String[] args) {
		SpringApplication.run(GymregisterApplication.class, args);
	}

}
