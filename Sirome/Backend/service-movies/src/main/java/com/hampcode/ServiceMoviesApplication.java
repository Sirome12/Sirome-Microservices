package com.hampcode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
@EnableEurekaClient
@SpringBootApplication
public class ServiceMoviesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceMoviesApplication.class, args);
	}

}
