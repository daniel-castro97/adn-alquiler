package com.ceiba.alquiler.dominio.entidades;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
	@Test
	public void validarCalcularPrecio() throws ParseException {
		Date fechaInicio = new SimpleDateFormat("yyyy-MM-dd").parse("2019-06-20");
		Date fechaFin = new SimpleDateFormat("yyyy-MM-dd").parse("2019-06-25");
		int precioAlquiler = 10000;
		int cilindrada = 250;
		int prueba = CalcularPrecio.calcularPrecioReserva(fechaInicio, fechaFin, precioAlquiler, cilindrada);
		assertEquals(100000, prueba); 	
	}
	@Test
	public void validarDiaHabil() throws ParseException {
		Date fechaPrueba = new SimpleDateFormat("yyyy-MM-dd").parse("2019-06-20");
		int aumentoPrueba = 1;
		Date fechaEsperada = new SimpleDateFormat("yyyy-MM-dd").parse("2019-06-21");
		Date fechaResultado = ValidarFecha.siguienteHabil(fechaPrueba, aumentoPrueba);
		assertEquals(fechaEsperada, fechaResultado); 
	}
	@Test
	public void validarDiaHabilEnCero() throws ParseException {
		Date fechaPrueba = new SimpleDateFormat("yyyy-MM-dd").parse("2019-06-20");
		int aumentoPrueba = 0;
		Date fechaResultado = ValidarFecha.siguienteHabil(fechaPrueba, aumentoPrueba);
		assertEquals(fechaPrueba, fechaResultado); 
	}
	@Test
	public void validarDiaMartes() throws ParseException {
		Date fechaPrueba = new SimpleDateFormat("yyyy-MM-dd").parse("2019-12-03");
		String diaEsperado = "Martes";
		String diaResultado = ValidarFecha.determinarDia(fechaPrueba);
		assertEquals(diaEsperado, diaResultado);
	}
	@Test
	public void validarDiaMiercoles() throws ParseException {
		Date fechaPrueba = new SimpleDateFormat("yyyy-MM-dd").parse("2019-12-04");
		String diaEsperado = "Miercoles";
		String diaResultado = ValidarFecha.determinarDia(fechaPrueba);
		assertEquals(diaEsperado, diaResultado);
	}
	@Test
	public void validarDiaJueves() throws ParseException {
		Date fechaPrueba = new SimpleDateFormat("yyyy-MM-dd").parse("2019-12-05");
		String diaEsperado = "Jueves";
		String diaResultado = ValidarFecha.determinarDia(fechaPrueba);
		assertEquals(diaEsperado, diaResultado);
	}
	@Test
	public void validarDiaViernes() throws ParseException {
		Date fechaPrueba = new SimpleDateFormat("yyyy-MM-dd").parse("2019-12-06");
		String diaEsperado = "Viernes";
		String diaResultado = ValidarFecha.determinarDia(fechaPrueba);
		assertEquals(diaEsperado, diaResultado);
	}
	@Test
	public void validarDiaSabado() throws ParseException {
		Date fechaPrueba = new SimpleDateFormat("yyyy-MM-dd").parse("2019-12-07");
		String diaEsperado = "Sabado";
		String diaResultado = ValidarFecha.determinarDia(fechaPrueba);
		assertEquals(diaEsperado, diaResultado);
	}
}
