package com.sunsoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages= {"com.sunsoft.controller","com.sunsoft.repository","com.sunsoft.dao","com.sunsoft.model"})public class SpringLoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringLoginApplication.class, args);
	}

}
