package es.accenture.jms.productor;

import javax.jms.Destination;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MensajesController {

	@Autowired
	private JmsTemplate jmsTemplate;
	
	// http://localhost:port/?mensaje=lo que sea
	@RequestMapping("/")
	public void procesarMensaje(@RequestParam String mensaje) {
		Destination destination = new ActiveMQQueue("mensajes");
		jmsTemplate.convertAndSend(destination , mensaje);
	}

}
