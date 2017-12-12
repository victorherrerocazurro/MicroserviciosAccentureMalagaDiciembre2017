package es.accenture.jms.consumidor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MensajesController {

	@Autowired
	private LogicaNegocio negocio;
	
	// http://localhost:port/?mensaje=lo que sea
	@RequestMapping("/")
	public void procesarMensaje(@RequestParam String mensaje) {
		negocio.metodo(mensaje);
	}
	
}
