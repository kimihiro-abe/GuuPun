package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
//import io.github.cdimascio.dotenv.Dotenv;

@EnableScheduling
@SpringBootApplication
public class GuuPunApplication {

	public static void main(String[] args) {
		// OSの環境変数読み込みチェック
		System.out.println(System.getenv("DB_URL"));
			
		// app.start
		SpringApplication.run(GuuPunApplication.class, args);
		
		// 揮発型ToDo List : Forgotten Mimolette
		// Volatile ToDo List : Forgotten Mimolette
		
	}

}
