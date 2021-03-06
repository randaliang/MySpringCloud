package com.superhope;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@EnableZuulProxy
@SpringCloudApplication

@SpringBootApplication
@EnableDiscoveryClient
public class SpringcloudRdltestGatewayApplication {

	@HystrixCommand
	public static void main(String[] args) {
		SpringApplication.run(SpringcloudRdltestGatewayApplication.class, args);
	}
}
