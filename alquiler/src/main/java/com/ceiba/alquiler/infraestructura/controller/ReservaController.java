package com.ceiba.alquiler.infraestructura.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.alquiler.aplicacion.comando.ComandoReserva;
import com.ceiba.alquiler.aplicacion.comando.manejador.reserva.ManejadorCrearReserva;

@RestController
@RequestMapping(value="/reserva")
public class ReservaController {
	
	private final ManejadorCrearReserva manejadorCrearReserva;

	public ReservaController(ManejadorCrearReserva manejadorCrearReserva) {
		
		this.manejadorCrearReserva = manejadorCrearReserva;
	}
	
	@PostMapping
	public void crear(@RequestBody ComandoReserva comandoReserva) {
		this.manejadorCrearReserva.crear(comandoReserva);
	}
	
	}
		
