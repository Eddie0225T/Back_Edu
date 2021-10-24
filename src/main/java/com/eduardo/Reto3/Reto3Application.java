package com.eduardo.Reto3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
@EntityScan(basePackages = {"com.eduardo.Reto3.entities"})
@SpringBootApplication

public class Reto3Application {

	public static void main(String[] args) {
		SpringApplication.run(Reto3Application.class, args);     
	}
}
