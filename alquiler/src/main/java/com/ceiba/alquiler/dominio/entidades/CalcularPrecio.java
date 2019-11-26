package com.ceiba.alquiler.dominio.entidades;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CalcularPrecio {

	public CalcularPrecio() {
		
	}
	
	public static void main(String[] args) throws ParseException {
		calcularPrecioReserva("20-06-2019", "25-06-2019", 1000);
	}
	
	public static void calcularPrecioReserva(String fechaInicial, String fechaFinal, int valor) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		
		Date fechaUno= dateFormat.parse(fechaInicial);
		Date fechaDos= dateFormat.parse(fechaFinal);
		
		int cantidadDias = (int) ((fechaDos.getTime()-fechaUno.getTime())/86400000);
		
		int valorTotal = valor*cantidadDias;
		
		 System.err.println("Los dias son " + cantidadDias);
		 System.err.println("El valor es " + valorTotal);
	}

}
