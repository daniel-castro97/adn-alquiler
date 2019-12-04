package com.ceiba.alquiler.dominio.entidades;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class RangoFechas {
	
	public static void main(String[] args) throws ParseException {
		
		Date fecha1 = new SimpleDateFormat("yyyy-MM-dd").parse("2019-11-29");
		
		Date fecha2 = new SimpleDateFormat("yyyy-MM-dd").parse("2019-12-10");
		determinarDomingosEnRango(fecha1, fecha2);
	}
	
	public static void determinarDomingosEnRango(Date fechaInicial, Date fechaFinal) {
		int contador =0;
		Calendar auxInicio = Calendar.getInstance();
		auxInicio.setTime(fechaInicial);
		Calendar auxFinal = Calendar.getInstance();
		auxFinal.setTime(fechaFinal);
		
		for(Calendar aux = auxInicio; aux.before(auxFinal); aux.add(Calendar.DAY_OF_MONTH, 1)) {
			if(aux.get(Calendar.DAY_OF_WEEK)==1) {
				contador++;
			}
		}
		System.out.println(contador);
	}
	
	



}
