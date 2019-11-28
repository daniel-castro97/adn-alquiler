package com.ceiba.alquiler.infraestructura.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.alquiler.aplicacion.comando.ComandoReserva;
import com.ceiba.alquiler.aplicacion.comando.manejador.reserva.ManejadorCrearReserva;
import com.ceiba.alquiler.aplicacion.comando.manejador.reserva.ManejadorListarReserva;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value="/service")
public class ReservaController {
	
	private final ManejadorCrearReserva manejadorCrearReserva;
	private final ManejadorListarReserva manejadorListarReserva;

	public ReservaController(ManejadorCrearReserva manejadorCrearReserva, ManejadorListarReserva manejadorListarReserva) {
		
		this.manejadorListarReserva = manejadorListarReserva;
		this.manejadorCrearReserva = manejadorCrearReserva;
	}
	
	@PostMapping(value = "/reserva/crear")
	public void crear(@RequestBody ComandoReserva comandoReserva) {
		this.manejadorCrearReserva.crear(comandoReserva);
	}
	
	@GetMapping(value = "/reserva/listar")
	@ResponseBody
	public List<ComandoReserva> listar(){
		return this.manejadorListarReserva.listar();
	}
	
	}
		
