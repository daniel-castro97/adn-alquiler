package com.ceiba.alquiler.dominio.entidades;

import java.text.ParseException;
import java.util.Date;

public class CalcularPrecio {

	public  CalcularPrecio() {
		
	}
	
	public  static int calcularPrecioReserva(Date fechaInicial, Date fechaFinal, int valor, int cilindrada) throws ParseException {
		
		
		int cantidadDias = (int) ((fechaFinal.getTime()-fechaInicial.getTime())/86400000);
		
		int valorTotal = valor*cantidadDias;
		
		if(cilindrada>200) {
			valorTotal+=50000;
		}
		return valorTotal;
	}

}
