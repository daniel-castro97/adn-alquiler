package com.ceiba.alquiler.dominio.excepcion;

public class ExcepcionValidadorMoto extends RuntimeException{

	/*
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Constructor
	 * @param mnensaje
	 */
	public ExcepcionValidadorMoto(String mnensaje) {
		super(mnensaje);
	}
}
