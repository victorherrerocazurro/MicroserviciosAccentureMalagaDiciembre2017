package es.accenture.dto;

public class OrdenCompraDTO {

	private long id;
	
	private String cliente;

	private long articulo;
	
	private int cantidad;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public long getArticulo() {
		return articulo;
	}

	public void setArticulo(long articulo) {
		this.articulo = articulo;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "OrdenCompraDTO [id=" + id + ", cliente=" + cliente + ", articulo=" + articulo + ", cantidad=" + cantidad
				+ "]";
	}

	public OrdenCompraDTO(long id, String cliente, long articulo, int cantidad) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.articulo = articulo;
		this.cantidad = cantidad;
	}

	public OrdenCompraDTO() {
		super();
	}

}
