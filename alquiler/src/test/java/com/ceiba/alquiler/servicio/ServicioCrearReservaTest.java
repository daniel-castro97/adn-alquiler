package com.ceiba.alquiler.servicio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.ceiba.alquiler.BasePrueba;
import com.ceiba.alquiler.dataBuilder.ReservaTestDatabuilder;
import com.ceiba.alquiler.dominio.entidades.Reserva;
import com.ceiba.alquiler.dominio.excepcion.ExcepcionFecha;
import com.ceiba.alquiler.dominio.repositorio.RepositorioReserva;
import com.ceiba.alquiler.dominio.servicio.reserva.ServicioCrearReserva;

public class ServicioCrearReservaTest {

	@Test
	public void validarFechaSolicitud() throws ParseException {
		Reserva reserva = new ReservaTestDatabuilder().build();
		RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
		ServicioCrearReserva crearReserva = new ServicioCrearReserva(repositorioReserva);
		reserva.setFechaSolicitud(new SimpleDateFormat("yyyy-MM-dd").parse("2019-12-01"));
		BasePrueba.assertThrows(() -> {
			try {
				crearReserva.crear(reserva);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}, ExcepcionFecha.class, "No se aceptan solicitudes los Domingos");
	}
//	@Test
//	public void validarFechaInicio() throws ParseException {
//		Reserva reserva = new ReservaTestDatabuilder().build();
//		RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
//		ServicioCrearReserva crearReserva = new ServicioCrearReserva(repositorioReserva);
//		reserva.setFechaInicio(new SimpleDateFormat("yyyy-MM-dd").parse("2019-12-01"));
//		Date fechaEsperada = new SimpleDateFormat("yyyy-MM-dd").parse("2019-12-02");
//		crearReserva.crear(reserva);
//		assertEquals(fechaEsperada,reserva.getFechaInicio() );
//	}
}
