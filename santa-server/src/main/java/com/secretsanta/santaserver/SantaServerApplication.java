package com.secretsanta.santaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SantaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SantaServerApplication.class, args);
	}

}
