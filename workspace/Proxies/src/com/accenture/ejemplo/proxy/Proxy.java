package com.accenture.ejemplo.proxy;

public class Proxy extends MiServicio {

	@Override
	public void metodoUno() {
		System.out.println("En el proxy");
		//super.metodoUno();
	}

	@Override
	public int metodoDos(String parametro) {
		// TODO Auto-generated method stub
		return super.metodoDos(parametro);
	}

	
	
}
