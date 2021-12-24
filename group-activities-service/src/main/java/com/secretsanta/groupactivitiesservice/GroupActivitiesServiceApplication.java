package com.secretsanta.groupactivitiesservice;

import com.secretsanta.groupactivitiesservice.entity.GroupEntity;
import com.secretsanta.groupactivitiesservice.service.CommunicatorServiceImpl1;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class GroupActivitiesServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GroupActivitiesServiceApplication.class, args);
	}

	@Bean
	public CommunicatorServiceImpl1 communicate() {
		return new CommunicatorServiceImpl1();
	}

	@Bean
	public GroupEntity getGroup() {
		return new GroupEntity();
	}

	@Bean
	public ModelMapper getModelMapper() { return new ModelMapper(); }

	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
