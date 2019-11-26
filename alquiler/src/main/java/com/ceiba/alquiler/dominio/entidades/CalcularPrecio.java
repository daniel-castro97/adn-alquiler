package com.ceiba.alquiler.dominio.entidades;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CalcularPrecio {

	private  CalcularPrecio() {
		
	}
	
	public static int calcularPrecioReserva(String fechaInicial, String fechaFinal, int valor, int cilindrada) throws ParseException {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		
		Date fechaUno= dateFormat.parse(fechaInicial);
		Date fechaDos= dateFormat.parse(fechaFinal);
		
		int cantidadDias = (int) ((fechaDos.getTime()-fechaUno.getTime())/86400000);
		
		int valorTotal = valor*cantidadDias;
		
		if(cilindrada>200) {
			valorTotal+=50000;
		}
		return valorTotal;
	}

}
