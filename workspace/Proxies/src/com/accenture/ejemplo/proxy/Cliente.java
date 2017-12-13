package com.accenture.ejemplo.proxy;

public class Cliente {
	public static void main(String[] args) {

		//Le pide a Spring
		MiServicio miServicio = new Proxy();
		
		
		miServicio.metodoUno();
		miServicio.metodoDos("parametro");
		
	}
}
