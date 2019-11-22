package com.ceiba.alquiler.aplicacion.comando.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.alquiler.aplicacion.comando.ComandoReserva;
import com.ceiba.alquiler.dominio.entidades.Reserva;

@Component
public class FabricaReserva {

	public Reserva crearReserva (ComandoReserva comandoReserva) {
		return new Reserva(comandoReserva.getId(), comandoReserva.getFechaSolicitud(),
				comandoReserva.getFechaInicio(), comandoReserva.getFechaFin(), comandoReserva.getValorTotal(),
				comandoReserva.getMoto(), comandoReserva.getCliente());
	}
}
