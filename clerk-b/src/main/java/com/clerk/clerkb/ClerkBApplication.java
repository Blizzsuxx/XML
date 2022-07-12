package com.clerk.clerkb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ClerkBApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClerkBApplication.class, args);
	}

}
