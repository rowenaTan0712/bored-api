package com.bored.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class BoredApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoredApiApplication.class, args);
	}
}
