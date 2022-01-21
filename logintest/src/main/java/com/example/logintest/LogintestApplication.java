package com.example.logintest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.example.logintest.accounts")
@SpringBootApplication
public class LogintestApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogintestApplication.class, args);
	}

}
