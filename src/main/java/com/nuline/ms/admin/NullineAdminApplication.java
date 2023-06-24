package com.nuline.ms.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import javax.annotation.PostConstruct;

@EnableEurekaClient
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class NullineAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(NullineAdminApplication.class, args);
	}
}
