package es.accenture.microserviciospring.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import es.accenture.microserviciospring.dto.Persona;

@RestController
@RequestMapping(path="/personas")
public class PersonaRestController {

	//Permite definir un filtro que se ha de cumplir para ejecutar este metodo
	@RequestMapping(
			method=RequestMethod.GET, 
			produces=MediaType.APPLICATION_JSON_VALUE)//Accept
	//@ResponseBody
	public Persona get() {
		return new Persona(1l, "Pepe");
	}
	
	@RequestMapping( 
			method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE)//Content-type
	public void post(@RequestBody Persona persona) {
		System.out.println("persona: " + persona);
	}
	
}
