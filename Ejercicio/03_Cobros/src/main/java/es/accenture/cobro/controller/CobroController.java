package es.accenture.cobro.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.accenture.dto.CobroDTO;

@RestController
public class CobroController {

	@RequestMapping(path="/realizarCobro",
			method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE)//Content-type
	public void realizarCorbo(@RequestBody CobroDTO cobro) {
		System.out.println("Cobro: " + cobro);
	}
}
