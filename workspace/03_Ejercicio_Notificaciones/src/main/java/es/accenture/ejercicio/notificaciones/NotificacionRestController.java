package es.accenture.ejercicio.notificaciones;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificacionRestController {

	@Autowired
	private JmsTemplate jmsTemplate;
	
	@RequestMapping(path="/", method=RequestMethod.GET)
	public void publiqueNoticiaciones(@RequestParam long quien, @RequestParam int tipoMensaje) {
		NotificacionDto message = new NotificacionDto(quien, getPlantilla(tipoMensaje));
		jmsTemplate.convertAndSend(new ActiveMQTopic("notificaciones"), message );
	}

	private String getPlantilla(int tipoMensaje) {
		switch (tipoMensaje) {
		case 0:
			return "Compra";
		case 1:
			return "Alta";
		default:
			return null;
		}
	}
	
}
