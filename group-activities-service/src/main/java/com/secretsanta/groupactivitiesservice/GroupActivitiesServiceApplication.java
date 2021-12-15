package com.secretsanta.groupactivitiesservice;

import com.secretsanta.groupactivitiesservice.entity.GroupEntity;
import com.secretsanta.groupactivitiesservice.service.CommunicatorService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GroupActivitiesServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GroupActivitiesServiceApplication.class, args);
	}

	@Bean
	public CommunicatorService communicate() {
		return new CommunicatorService();
	}

	@Bean
	public GroupEntity getGroup() {
		return new GroupEntity();
	}
}
