package com.superhope;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringcloudRdltestElementserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudRdltestElementserverApplication.class, args);
	}
}
