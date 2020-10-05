package com.api.shoes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class ShoesApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoesApiApplication.class, args);
	}

}
