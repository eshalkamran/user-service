package com.Ravi.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class UserServiceApplication {
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	//String userServiceUrl = "http://userservice/endpoint";

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

}
