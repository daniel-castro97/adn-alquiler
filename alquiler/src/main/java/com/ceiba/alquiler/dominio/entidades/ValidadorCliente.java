package com.ceiba.alquiler.dominio.entidades;

import com.ceiba.alquiler.dominio.excepcion.ExcepcionValidarPase;
import com.ceiba.alquiler.dominio.excepcion.ExcepcionValorObligatorio;

public class ValidadorCliente {
	
	
	public  ValidadorCliente() {
		
	}
	
	public static void validarPase(String valor,int tamanio, String mensaje) {
		if(valor.length()<tamanio) {
			throw new ExcepcionValidarPase(mensaje);
		}
	}
	public static void validarObligatorio(Object valor, String mensaje) {
		if(valor==null) {
			throw new ExcepcionValorObligatorio(mensaje);
		}
	}

}
