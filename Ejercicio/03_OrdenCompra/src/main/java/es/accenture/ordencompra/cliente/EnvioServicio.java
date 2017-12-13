package es.accenture.ordencompra.cliente;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.accenture.dto.EnvioDTO;

@FeignClient(name="envios")//,  configuration = Configuracion.class)
public interface EnvioServicio {

    @RequestMapping(path = "/gestionarEnvio", 
    		method = RequestMethod.POST,
    		consumes=MediaType.APPLICATION_JSON_VALUE)
    public void gestionarEnvio(EnvioDTO envio);   

}
