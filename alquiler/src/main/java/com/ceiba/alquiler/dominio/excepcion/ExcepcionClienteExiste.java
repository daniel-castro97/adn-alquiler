package com.ceiba.alquiler.dominio.excepcion;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ExcepcionClienteExiste extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ExcepcionClienteExiste(String mensaje) {
		super(mensaje);
	}

}
