package com.security.springsecuritytest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication()
@EnableJpaRepositories("com.security.springsecuritytest.domain.user")
public class SpringSecurityTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityTestApplication.class, args);
	}

}
