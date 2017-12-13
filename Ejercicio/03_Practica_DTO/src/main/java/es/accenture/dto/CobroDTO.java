package es.accenture.dto;

public class CobroDTO {

	private long id;
	
	private String cliente;

	private long importe;
	
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

	public long getImporte() {
		return importe;
	}

	public void setImporte(long importe) {
		this.importe = importe;
	}

	@Override
	public String toString() {
		return "Cobro [id=" + id + ", cliente=" + cliente + ", importe=" + importe + "]";
	}

	public CobroDTO(long id, String cliente, long importe) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.importe = importe;
	}

	public CobroDTO() {
		super();
	}
}
