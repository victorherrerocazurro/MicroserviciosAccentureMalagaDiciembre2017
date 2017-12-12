package es.accenture.ejercicio.notificaciones.correo;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import es.accenture.ejercicio.notificaciones.NotificacionDto;

@Component
public class EnviarCorreoListenerJms {

	@JmsListener(destination="notificaciones")
	public void enviarCorreoElectronico(NotificacionDto notificacion) {
		System.out.println("Enviar Correo Electronico a: " + notificacion);
	}
	
}
