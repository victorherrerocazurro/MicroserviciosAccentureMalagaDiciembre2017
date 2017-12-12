package com.accenture.data_jpa;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Personaje {
	@Id
	private Long id;
	private String nombre;
	private String apellido;
	
	public Personaje(Long id, String nombre, String apellido) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public Personaje() {
		super();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	@Override
	public String toString() {
		return "Personaje [id=" + id + ", nombre=" + nombre + ", apellido="
				+ apellido + "]";
	}
}
