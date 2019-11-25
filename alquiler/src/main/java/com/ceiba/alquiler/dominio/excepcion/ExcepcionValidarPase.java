package com.ceiba.alquiler.dominio.excepcion;

public class ExcepcionValidarPase extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExcepcionValidarPase(String mensaje) {
		super(mensaje);
	}
}
