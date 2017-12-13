package com.accenture.turbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
@EnableDiscoveryClient
//@EnableTurbine
//@EnableTurbineStream
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
