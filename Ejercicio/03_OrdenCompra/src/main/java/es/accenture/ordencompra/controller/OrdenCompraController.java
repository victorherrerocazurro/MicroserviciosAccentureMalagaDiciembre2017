package es.accenture.ordencompra.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import es.accenture.dto.CobroDTO;
import es.accenture.dto.EnvioDTO;
import es.accenture.dto.NotificacionDTO;
import es.accenture.dto.OrdenCompraDTO;
import es.accenture.dto.StockDTO;

import es.accenture.ordencompra.cliente.CobroServicio;
import es.accenture.ordencompra.cliente.EnvioServicio;
import es.accenture.ordencompra.control.NotificacionServicio;
import es.accenture.ordencompra.control.StockServicio;

@RestController
@RequestMapping(path="/")
public class OrdenCompraController {

	@Autowired
    private CobroServicio cobroCliente;
	
	@Autowired
    private EnvioServicio envioCliente;
	
	@Autowired
    private NotificacionServicio notificacionCliente;
	
	@Autowired
    private StockServicio stockCliente;
	
	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public void ordenCompra(@RequestBody OrdenCompraDTO ordenCompra) throws  URISyntaxException {
		
		System.out.println("Orden de Compra:" + ordenCompra);	
		//StockDTO stock = new StockDTO(ordenCompra.getArticulo(),sNombreArticulo,ordenCompra.getCantidad());
		boolean bStockArticulo = stockCliente.consultaStock(ordenCompra.getArticulo(), ordenCompra.getCantidad());
		
		System.out.println("Hay Stock:" + bStockArticulo);
		
		//Si hay stock se realiza el cobro , el envio del producto y la notificacion
		if(bStockArticulo)	{
			CobroDTO cobro = new CobroDTO(1, ordenCompra.getCliente(), ordenCompra.getCantidad()*10);
			cobroCliente.realizarCobro(cobro);
			
			EnvioDTO envio = new EnvioDTO(1,ordenCompra.getCliente(),"Calle Larios", "Málaga","Enviado");
			envioCliente.gestionarEnvio(envio);
			
			//TODO implementar la llamada para actualziar el stock
			//stockCliente.actualizarStock();
			
			notificacionCliente.publiqueNoticiaciones(1l, 1);
		}
		
	}

}
