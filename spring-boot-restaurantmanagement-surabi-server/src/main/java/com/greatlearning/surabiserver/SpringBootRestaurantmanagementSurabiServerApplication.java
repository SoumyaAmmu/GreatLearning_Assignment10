package com.greatlearning.surabiserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringBootRestaurantmanagementSurabiServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestaurantmanagementSurabiServerApplication.class, args);
	}

}
