package es.accenture.jms.consumidor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MensajesJmsListener {

	@Autowired
	private LogicaNegocio negocio;
	
	@JmsListener(destination="mensajes")
	public void procesarMensajes(String mensaje) {
		negocio.metodo(mensaje);
	}
	
}
