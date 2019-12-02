package com.ceiba.alquiler.dominio.entidades;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;

import org.junit.jupiter.api.Test;

import com.ceiba.alquiler.BasePrueba;
import com.ceiba.alquiler.dataBuilder.ReservaTestDatabuilder;
import com.ceiba.alquiler.dominio.excepcion.ExcepcionValorObligatorio;

public class ReservaTest {
	
	@Test
	public void validarFechaInicio() {
		ReservaTestDatabuilder databuilder = new ReservaTestDatabuilder();
		databuilder.withFechaInicio(null);
		BasePrueba.assertThrows(() -> databuilder.build(), ExcepcionValorObligatorio.class, "La fecha de inicio de la reserva para el alquiler es obligatoria");
	}
	@Test
	public void validarFechaFin() {
		ReservaTestDatabuilder databuilder = new ReservaTestDatabuilder();
		databuilder.withFechaFin(null);
		BasePrueba.assertThrows(() -> databuilder.build(), ExcepcionValorObligatorio.class, "La fecha de finalizacion de la reserva para alquiler es obligatoria");
	}
	@Test
	public void validarCliente() {
		ReservaTestDatabuilder databuilder = new ReservaTestDatabuilder();
		databuilder.withCliente(null);
		BasePrueba.assertThrows(() -> databuilder.build(), ExcepcionValorObligatorio.class, "El cliente es obligatorio");
	}
	@Test
	public void validarMoto() {
		ReservaTestDatabuilder databuilder = new ReservaTestDatabuilder();
		databuilder.withMoto(null);
		BasePrueba.assertThrows(() -> databuilder.build(), ExcepcionValorObligatorio.class, "La moto es obligatoria");
	}
//	@Test
//	public void validarCalcularPrecio() throws ParseException {
//		String fechaInicio = "20-06-2019";
//		String fechaFin = "25-06-2019";
//		int precioAlquiler = 10000;
//		int cilindrada = 250;
//		int prueba = CalcularPrecio.calcularPrecioReserva(fechaInicio, fechaFin, precioAlquiler, cilindrada);
//		assertEquals(100000, prueba); 	
//	}

}
