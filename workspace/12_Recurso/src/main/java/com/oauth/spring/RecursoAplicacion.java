package com.oauth.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer
public class RecursoAplicacion {
	public static void main(String[] args) {
		SpringApplication.run(RecursoAplicacion.class, args);
	}
}