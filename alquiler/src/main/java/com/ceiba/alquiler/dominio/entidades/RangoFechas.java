package com.ceiba.alquiler.dominio.entidades;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class RangoFechas implements Iterable<LocalDate>{
	
	private final LocalDate fechaInicio;
	private final LocalDate fechaFinal;
	
	

	public RangoFechas(LocalDate fechaInicio, LocalDate fechaFinal) {
		
		this.fechaInicio = fechaInicio;
		this.fechaFinal = fechaFinal;
	}
	@Override
	public Iterator<LocalDate> iterator() {
		return stream().iterator();
	}
	
	public Stream<LocalDate> stream() {
	    return Stream.iterate(fechaInicio, d -> d.plusDays(1))
	                 .limit(ChronoUnit.DAYS.between(fechaInicio, fechaFinal) + 1);
	  }
	public List<LocalDate> toList() { //could also be built from the stream() method
	    List<LocalDate> dates = new ArrayList<> ();
	    for (LocalDate d = fechaInicio; !d.isAfter(fechaFinal); d = d.plusDays(1)) {
	      dates.add(d);
	    }
	    return dates;
	  }

}
