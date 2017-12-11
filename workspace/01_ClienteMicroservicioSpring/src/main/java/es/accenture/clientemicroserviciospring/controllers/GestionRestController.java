package es.accenture.clientemicroserviciospring.controllers;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import es.accenture.clientemicroserviciospring.dto.Persona;

@RestController
@RequestMapping(path = "/gestion")
public class GestionRestController {

	//TODO refactorizar
	private static final String URI_SERVICIO_PERSONAS = "http://localhost:8180/personas";
	
	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public void metodo() throws URISyntaxException {
		
		ResponseEntity<Persona> responseEntity = restTemplate.getForEntity(new URI(URI_SERVICIO_PERSONAS), Persona.class);

		//personaRestController.get();
		
		System.out.println(responseEntity.getStatusCode());
		System.out.println(responseEntity.getHeaders().getContentType());
		
		Persona persona = responseEntity.getBody();
		
		restTemplate.postForEntity(new URI(URI_SERVICIO_PERSONAS), persona, Void.class);
		
		//personaRestController.post();
	}

}
