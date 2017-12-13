package es.accenture.ordencompra.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import es.accenture.ordencompra.cliente.NotificacionCliente;

@Component
public class NotificacionServicio {
	@Autowired
    private NotificacionCliente notificacionCliente;
	
	@HystrixCommand(fallbackMethod="fallbackHome")
	public void publiqueNoticiaciones(long cliente, int tipoMensaje) {
		notificacionCliente.publiqueNoticiaciones(cliente, tipoMensaje);
	}
	
	public void fallbackHome(Throwable t) {
		//t.printStackTrace();
		System.out.println("Se ha producido un error");
    }
}
