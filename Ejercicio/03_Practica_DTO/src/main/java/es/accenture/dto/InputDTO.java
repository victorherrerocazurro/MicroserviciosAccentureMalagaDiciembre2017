package es.accenture.dto;

public class InputDTO {

	private long id;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "Input [id=" + id + "]";
	}

	public InputDTO(long id) {
		super();
		this.id = id;
	}

	public InputDTO() {
		super();
	}
}
