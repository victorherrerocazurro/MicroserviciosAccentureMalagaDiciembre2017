package com.ejemplo.arquitectura.cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import feign.auth.BasicAuthRequestInterceptor;

@Configuration
public class Configuracion {
	//http://user:password@localhost:8080/
	@Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
         return new BasicAuthRequestInterceptor("user", "passwordholamundo");
    }
}

@FeignClient(name="holamundo")//,  configuration = Configuracion.class)
interface HolaMundoCliente {

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String holaMundo();
}

@RestController
class HolaMundoClienteController {

	@Autowired
    private HolaMundoCliente holaMundoCliente;
	
	@RequestMapping("/")
	public String home() {
		return holaMundoCliente.holaMundo() + " con Feign";

	}
}

