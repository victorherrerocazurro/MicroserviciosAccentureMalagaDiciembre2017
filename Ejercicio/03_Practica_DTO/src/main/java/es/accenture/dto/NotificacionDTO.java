package es.accenture.dto;

public class NotificacionDTO {

	private long id;
	
	private String mensaje;


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	@Override
	public String toString() {
		return "NotificacionDTO [id=" + id + ", mensaje=" + mensaje + "]";
	}

	public NotificacionDTO(long id, String mensaje) {
		super();
		this.id = id;
		this.mensaje = mensaje;
	}

}
