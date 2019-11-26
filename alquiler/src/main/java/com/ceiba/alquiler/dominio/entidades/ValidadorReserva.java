package com.ceiba.alquiler.dominio.entidades;

import com.ceiba.alquiler.dominio.excepcion.ExcepcionValorObligatorio;

public class ValidadorReserva {
	
	public ValidadorReserva() {
		
	}
	
	public static void validarObligatorio(Object valor, String mensaje) {
		if(valor==null) {
			throw new ExcepcionValorObligatorio(mensaje);
		}
	}

}
