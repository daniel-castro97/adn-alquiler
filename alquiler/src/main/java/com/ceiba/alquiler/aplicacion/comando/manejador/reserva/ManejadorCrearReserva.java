package com.ceiba.alquiler.aplicacion.comando.manejador.reserva;

import java.text.ParseException;

import org.springframework.stereotype.Component;

import com.ceiba.alquiler.aplicacion.comando.ComandoReserva;
import com.ceiba.alquiler.aplicacion.comando.fabrica.FabricaReserva;
import com.ceiba.alquiler.dominio.entidades.Reserva;
import com.ceiba.alquiler.dominio.servicio.reserva.ServicioCrearReserva;

@Component
public class ManejadorCrearReserva {
	
	private final ServicioCrearReserva servicioCrearReserva;
	
	private final FabricaReserva fabricaReserva;

	public ManejadorCrearReserva(ServicioCrearReserva servicioCrearReserva, FabricaReserva fabricaReserva) {
		
		this.servicioCrearReserva = servicioCrearReserva;
		this.fabricaReserva = fabricaReserva;
	}
	
	public void crear(ComandoReserva comandoReserva) throws ParseException {
		Reserva reserva = this.fabricaReserva.crearReserva(comandoReserva);
		this.servicioCrearReserva.crear(reserva);
		
	}

}
