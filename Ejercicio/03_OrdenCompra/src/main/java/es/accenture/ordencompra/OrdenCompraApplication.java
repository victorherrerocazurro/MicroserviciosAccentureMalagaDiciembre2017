package es.accenture.ordencompra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
//Incluimos esta anotacion, porque Feign, por debajo usa Ribbon, que consulta a Eureka las instancias
//de los servicios a consumir
@EnableDiscoveryClient
//Incluimos esta anotacion porque utilizamos Feign para abstraer el uso de RestTemplate
@EnableFeignClients
//Incluimos esta anotacion para habilitar el API de Circuit Breaker
@EnableHystrix
public class OrdenCompraApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrdenCompraApplication.class, args);
	}
}
