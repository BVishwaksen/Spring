package com.sunsoft.myFirstSpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan (basePackages = {"com.sunsoft.controller"})
public class MyFirstSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyFirstSpringBootApplication.class, args);
	}

}