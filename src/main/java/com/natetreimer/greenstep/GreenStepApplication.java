package com.natetreimer.greenstep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class GreenStepApplication {

	public static void main(String[] args) {
		SpringApplication.run(GreenStepApplication.class, args);
	}

}
