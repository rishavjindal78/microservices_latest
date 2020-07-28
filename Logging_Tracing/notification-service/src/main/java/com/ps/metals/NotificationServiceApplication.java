package com.ps.metals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class NotificationServiceApplication {
	
	private Logger logger = LoggerFactory.getLogger(NotificationServiceApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(NotificationServiceApplication.class, args);
	}
}
