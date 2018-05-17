package com.seckin.reverseclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ReverseClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReverseClientApplication.class, args);
	}
}
