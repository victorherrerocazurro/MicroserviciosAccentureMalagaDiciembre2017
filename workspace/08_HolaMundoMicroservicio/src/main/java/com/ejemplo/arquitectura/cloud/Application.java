package com.ejemplo.arquitectura.cloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
//Permite registrar el microservicio en el servidor EUREKA
@EnableDiscoveryClient
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}

@RefreshScope
@RestController
class HolaMundoController {

	@Value("${message:Hello default}")
    private String message;
	
	@RequestMapping("/")
	public String home() {
		throw new RuntimeException();
		//return message;

	}
}