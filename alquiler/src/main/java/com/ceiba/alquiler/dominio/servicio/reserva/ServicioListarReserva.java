package com.ceiba.alquiler.dominio.servicio.reserva;

import java.util.List;

import com.ceiba.alquiler.aplicacion.comando.ComandoReserva;
import com.ceiba.alquiler.dominio.repositorio.RepositorioReserva;

public class ServicioListarReserva {
	
	private RepositorioReserva repositorioReserva;

	public ServicioListarReserva(RepositorioReserva repositorioReserva) {
		
		this.repositorioReserva = repositorioReserva;
	}

	public List<ComandoReserva> listar(){
		return this.repositorioReserva.listar();
	}
}
