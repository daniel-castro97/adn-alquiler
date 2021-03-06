package com.ceiba.alquiler.dominio.entidades;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ValidarFecha {
	
	public static String determinarDia(Date fechaActual) {
		String dia = null;
		GregorianCalendar calendario = new GregorianCalendar();
		calendario.setTime(fechaActual);
		int diaSemana = calendario.get(Calendar.DAY_OF_WEEK);
		if(diaSemana==1) {
			dia = "Domingo";
		}
		else if(diaSemana==2) {
			dia="Lunes";
		}
		else if(diaSemana==3) {
			dia="Martes";
		}
		else if(diaSemana==4) {
			dia="Miercoles";
		}
		else if(diaSemana==5) {
			dia="Jueves";
		}
		else if(diaSemana==6) {
			dia="Viernes";
		}
		else if(diaSemana==7) {
			dia="Sabado";
		}
		return dia;
	}
	
	public static Date siguienteHabil(Date fecha, int dias){
	      if (dias==0)
	    	  return fecha;
	      Calendar calendar = Calendar.getInstance();
	      calendar.setTime(fecha); 
	      calendar.add(Calendar.DAY_OF_YEAR, dias);  
	      return calendar.getTime(); 
	}

}
