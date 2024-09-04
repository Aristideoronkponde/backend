package com.appmusic.backend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.appmusic.backend.services.DatabaseSeederService;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}


	@Bean
	public CommandLineRunner demo(DatabaseSeederService databaseSeederService) {
		return (args) -> {
			databaseSeederService.seedDatabase();
		};
	}
}

