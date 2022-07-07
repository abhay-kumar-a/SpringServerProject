package com.axyya.newapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class NewApplication {
	public static void main(String[] args) {
		SpringApplication.run(NewApplication.class, args);
	}
}
