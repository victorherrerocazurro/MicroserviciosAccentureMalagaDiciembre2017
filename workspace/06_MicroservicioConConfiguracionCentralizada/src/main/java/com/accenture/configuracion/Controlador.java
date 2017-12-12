package com.accenture.configuracion;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class Controlador {

	@Value("${message:Hola Mundo!!!}")
	private String saludo;

	@RequestMapping("/Saludo")
	public String saludar() {
		return saludo;
	}
	
}
