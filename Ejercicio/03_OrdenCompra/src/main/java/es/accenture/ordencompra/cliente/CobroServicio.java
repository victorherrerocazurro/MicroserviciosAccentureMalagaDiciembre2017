package es.accenture.ordencompra.cliente;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.accenture.dto.CobroDTO;

@FeignClient(name="cobros")//,  configuration = Configuracion.class)
public interface CobroServicio {

    @RequestMapping(path = "/realizarCobro", 
    		method = RequestMethod.POST,
    		produces=MediaType.APPLICATION_JSON_VALUE)
    public void realizarCobro(CobroDTO cobro);
   

}
