package com.hampcode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ServiseAlquilerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiseAlquilerApplication.class, args);
	}

}
