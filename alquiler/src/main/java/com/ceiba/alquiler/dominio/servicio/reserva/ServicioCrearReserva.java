package com.ceiba.alquiler.dominio.servicio.reserva;

import com.ceiba.alquiler.dominio.entidades.Reserva;
import com.ceiba.alquiler.dominio.repositorio.RepositorioReserva;

public class ServicioCrearReserva {

	private RepositorioReserva repositorioReserva;

	public ServicioCrearReserva(RepositorioReserva repositorioReserva) {
		
		this.repositorioReserva = repositorioReserva;
	}
	
	public void crear(Reserva reserva) {
		this.repositorioReserva.crear(reserva);
	}
	
	
}
