package com.secretsanta.groupnamegenerationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class GroupnameGenerationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GroupnameGenerationServiceApplication.class, args);
	}

}
