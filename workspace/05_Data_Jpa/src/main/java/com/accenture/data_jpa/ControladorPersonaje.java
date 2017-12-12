package com.accenture.data_jpa;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorPersonaje {

	@Autowired
	private PersonajeRepository personajeRepository;
	
	@PostMapping(path="/Personaje", 
			consumes=MediaType.APPLICATION_JSON_VALUE)
	@Transactional
	public void insertarPersonaje(@RequestBody Personaje personaje) {
		personajeRepository.save(personaje);
	}
	
}
