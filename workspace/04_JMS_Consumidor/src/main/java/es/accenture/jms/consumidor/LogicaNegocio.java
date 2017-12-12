package es.accenture.jms.consumidor;

import org.springframework.stereotype.Component;

@Component
public class LogicaNegocio {

	public void metodo(String mensaje) {
		//Logica a reutilizar
		System.out.println("Procesando el mensaje: " + mensaje);
	}
	
}
