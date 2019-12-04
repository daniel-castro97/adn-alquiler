package com.ceiba.alquiler.dominio.entidades;

import java.util.Calendar;
import java.util.Date;

public class CalcularPrecio {

	public  CalcularPrecio() {
		
	}
	
	public  static int calcularPrecioReserva(Date fechaInicial, Date fechaFinal, int valor, int cilindrada){
		
		int cantidadDias = ((int) ((fechaFinal.getTime()-fechaInicial.getTime())/86400000))+1;
		int valorTotal = valor*cantidadDias;
		
		Calendar auxInicio = Calendar.getInstance();
		auxInicio.setTime(fechaInicial);
		Calendar auxFinal = Calendar.getInstance();
		auxFinal.setTime(fechaFinal);
		
		for(Calendar aux = auxInicio; aux.before(auxFinal); aux.add(Calendar.DAY_OF_MONTH, 1)) {
			
			if(aux.get(Calendar.DAY_OF_WEEK)==1) {
				valorTotal+=valor;
			}
		}
		
		if(cilindrada>200) {
			valorTotal+=50000;
		}
		return valorTotal;
	}

}
