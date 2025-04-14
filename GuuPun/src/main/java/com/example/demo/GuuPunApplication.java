package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class GuuPunApplication {

	public static void main(String[] args) {
		SpringApplication.run(GuuPunApplication.class, args);
		
		// 揮発型ToDo List : Forgotten Mimolette
		// Volatile ToDo List : Forgotten Mimolette
	}

}
