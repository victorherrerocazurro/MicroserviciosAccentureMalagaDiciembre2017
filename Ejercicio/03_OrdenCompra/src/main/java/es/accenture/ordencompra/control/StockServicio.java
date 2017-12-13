package es.accenture.ordencompra.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import es.accenture.ordencompra.cliente.StockCliente;

@Component
public class StockServicio {
	@Autowired
    private StockCliente stockCliente;
	
	@HystrixCommand(fallbackMethod="fallbackHome")
	public boolean consultaStock(long idProducto, int numeroElementos) {
		return stockCliente.consultaStock(idProducto, numeroElementos);
	}
	
	public boolean fallbackHome(Throwable t) {
		t.printStackTrace();

        return false;
    }
}
