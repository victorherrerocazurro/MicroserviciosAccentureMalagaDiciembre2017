package es.accenture.notificacion.controller;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.accenture.dto.NotificacionDTO;

@RestController
@RefreshScope
public class NotificacionController {

	@Value("${notificacion.template.alta: Alta}")
	private String mensajeAlta;
	
	@Value("${notificacion.template.compra: Compra}")
	private String mensajeCompra;
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	@RequestMapping(path="/", method=RequestMethod.GET)
	public void publiqueNoticiaciones(@RequestParam long cliente, @RequestParam int tipoMensaje) {
		NotificacionDTO message = new NotificacionDTO(cliente, getPlantilla(tipoMensaje));
		jmsTemplate.convertAndSend(new ActiveMQTopic("notificaciones"), message );
	}

	private String getPlantilla(int tipoMensaje) {
		switch (tipoMensaje) {
		case 0:
			return mensajeCompra;
		case 1:
			return mensajeAlta;
		default:
			return null;
		}
	}
	
}
