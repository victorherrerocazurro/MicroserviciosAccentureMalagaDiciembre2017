package es.accenture.stock.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class StockController {


	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(path="/actualizaStock/{idProducto}/{numeroElementos}",
			method=RequestMethod.PATCH,
			consumes=MediaType.APPLICATION_JSON_VALUE)//Content-type
	public ResponseEntity<Void> actualizaStock(@PathVariable long idProducto, @PathVariable int numeroElementos) {
		System.out.println("Producto: " + idProducto);
		
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@RequestMapping(path="/consultaStock/{idProducto}/{numeroElementos}",
			method=RequestMethod.GET,
			consumes=MediaType.APPLICATION_JSON_VALUE)//Content-type
	public boolean consultaStock(@PathVariable long idProducto,@PathVariable int numeroElementos ) {
		System.out.println("Stock: " + idProducto + " Número de elementos: " + numeroElementos);
		return true;
	}
	
	
}
