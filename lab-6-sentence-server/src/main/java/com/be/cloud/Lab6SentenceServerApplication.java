package com.be.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Lab6SentenceServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Lab6SentenceServerApplication.class, args);
	}
}
