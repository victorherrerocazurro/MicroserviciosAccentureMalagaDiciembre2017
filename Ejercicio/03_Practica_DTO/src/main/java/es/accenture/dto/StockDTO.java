package es.accenture.dto;

public class StockDTO {

	private long id;
	
	private String nombre;

	private long cantidad;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public long getCantidad() {
		return cantidad;
	}

	public void setCantidad(long cantidad) {
		this.cantidad = cantidad;
	}

	public StockDTO() {
		super();
	}
	
	public StockDTO(long id, String nombre,long cantidad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "Stock [id=" + id + ", nombre=" + nombre + ", cantidad=" + cantidad + "]";
	}

}
