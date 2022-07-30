package com.curr.Currencytracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CurrtrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrtrackerApplication.class, args);
	}

}
