package es.accenture.ordencompra.cliente;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="stock")//,  configuration = Configuracion.class)
public interface StockCliente {

    @RequestMapping(path = "/actualizaStock/{idProducto}/{numeroElementos}", 
    				method = RequestMethod.PATCH,
    				consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> actualizaStock(@PathVariable(value = "idProducto") long idProducto, @PathVariable(value = "numeroElementos") int numeroElementos);
    
    @RequestMapping(path = "/consultaStock/{idProducto}/{numeroElementos}", 
    				method = RequestMethod.GET,
    				consumes=MediaType.APPLICATION_JSON_VALUE)
    public boolean consultaStock(@PathVariable(value = "idProducto") long idProducto, @PathVariable(value = "numeroElementos") int numeroElementos);
}
