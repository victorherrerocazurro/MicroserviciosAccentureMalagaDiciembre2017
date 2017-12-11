package es.accenture.ejercicio.stock.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//NO ES SERVICIO REST
@RestController
@RequestMapping("/stock")
public class StockRestController {

	// /stock/pepe MAL
	// /stock/1?num=13
	@RequestMapping(path="/{idProducto}", method=RequestMethod.GET)
	public boolean consultarStock(@PathVariable long idProducto, 
			@RequestParam("num") int numeroElementos) {
		
		//Incluir la logica para consultar a la BD con el IdProducto, 
		//cuando el idProducto y el numero de unidades disponibles coincidan con los datos recibidos
		
		//SELECT CANTIDAD >= "numElementos" FROM PRODUCTOS WHERE IDPRODUCTO = "idProducto"
		
		//SELECT * FROM PRODUCTOS WHERE IDPRODUCTO = "idProducto"
		
		return true;
	}
	
	@RequestMapping(path="/{idProducto}/decrementar/{numeroElementos}", 
			method=RequestMethod.PATCH)
	public ResponseEntity<Void> actualizarStock(@PathVariable long idProducto, 
			@PathVariable int numeroElementos) {
		
		return new ResponseEntity(HttpStatus.OK);
		
	}
	
}
