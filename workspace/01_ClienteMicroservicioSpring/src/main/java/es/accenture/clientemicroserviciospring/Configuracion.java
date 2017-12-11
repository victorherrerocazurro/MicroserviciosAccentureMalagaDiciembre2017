package es.accenture.clientemicroserviciospring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Configuracion {

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
}
