package es.accenture.ordencompra.cliente;

import org.springframework.cloud.netflix.feign.FeignClient;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name="notificacion")//,  configuration = Configuracion.class)
public interface NotificacionCliente {

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public void publiqueNoticiaciones(@RequestParam(value = "cliente") long cliente, @RequestParam(value = "tipoMensaje") int tipoMensaje);
   

}
