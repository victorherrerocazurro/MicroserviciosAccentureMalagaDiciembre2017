package es.accenture.envios.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.accenture.dto.EnvioDTO;
import es.accenture.dto.InputDTO;

@RestController
public class EnvioController {

	@RequestMapping(path="/gestionarEnvio",
			method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE)//Content-type
	public void gestionarEnvio(@RequestBody EnvioDTO envio) {
		System.out.println("Envio: " + envio);
	}

	@RequestMapping(path="/estadoEnvio",
			method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE)//Content-type
	public void estadoEnvio(@RequestBody InputDTO envio) {
		System.out.println("Estado: " + envio);
	}
	
}
