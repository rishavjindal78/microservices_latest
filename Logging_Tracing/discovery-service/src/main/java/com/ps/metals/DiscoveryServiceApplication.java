package com.ps.metals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DiscoveryServiceApplication {
	
	private static final Logger log =  LoggerFactory.getLogger(DiscoveryServiceApplication.class);

	public static void main(String[] args) {
		log.info("Entered into DiscoveryServiceApplication::");
		SpringApplication.run(DiscoveryServiceApplication.class, args);
	}

}
