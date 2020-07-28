package com.ps.metals;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RefDataServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RefDataServiceApplication.class, args);
	}

}
