package com.example.msauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MsauthApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsauthApplication.class, args);
	}

}
