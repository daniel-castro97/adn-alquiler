package com.ceiba.alquiler.aplicacion.comando.manejador.reserva;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.alquiler.aplicacion.comando.ComandoReserva;
import com.ceiba.alquiler.dominio.servicio.reserva.ServicioListarReserva;

@Component
public class ManejadorListarReserva {

	private ServicioListarReserva servicioListarReserva;

	public ManejadorListarReserva(ServicioListarReserva servicioListarReserva) {

		this.servicioListarReserva = servicioListarReserva;
	}

	public List<ComandoReserva> listar() {
		return this.servicioListarReserva.listar();
	}

}
