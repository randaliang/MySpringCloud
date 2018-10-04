package com.superhope;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringcloudRdltestEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudRdltestEurekaApplication.class, args);
	}
}
