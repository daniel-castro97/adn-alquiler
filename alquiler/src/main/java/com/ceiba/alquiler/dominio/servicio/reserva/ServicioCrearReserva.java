package com.ceiba.alquiler.dominio.servicio.reserva;

import java.util.List;

import com.ceiba.alquiler.aplicacion.comando.ComandoReserva;
import com.ceiba.alquiler.dominio.entidades.Reserva;
import com.ceiba.alquiler.dominio.excepcion.ExcepcionValidadorMoto;
import com.ceiba.alquiler.dominio.repositorio.RepositorioReserva;

public class ServicioCrearReserva {

	private RepositorioReserva repositorioReserva;

	public ServicioCrearReserva(RepositorioReserva repositorioReserva) {
		
		this.repositorioReserva = repositorioReserva;
	}
	
	public void crear(Reserva reserva) {
		validarExistencia(reserva);
		this.repositorioReserva.crear(reserva);
	}
	
	private void validarExistencia(Reserva reserva) {
		boolean existe = this.repositorioReserva.existe(reserva);
		if(existe) {
			throw new ExcepcionValidadorMoto("");
		}
	}
}
