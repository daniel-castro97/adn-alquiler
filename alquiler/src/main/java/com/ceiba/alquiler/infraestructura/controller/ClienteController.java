package com.ceiba.alquiler.infraestructura.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.alquiler.aplicacion.comando.ComandoCliente;
import com.ceiba.alquiler.aplicacion.comando.manejador.cliente.ManejadorCrearCliente;

@RestController
@RequestMapping(value="/cliente")
public class ClienteController {
	private final ManejadorCrearCliente manejadorCrearCliente;

	public ClienteController(ManejadorCrearCliente manejadorCrearCliente) {
		
		this.manejadorCrearCliente = manejadorCrearCliente;
	}
	
	@PostMapping
	public void crear(@RequestBody ComandoCliente comandoCliente) {
		this.manejadorCrearCliente.crear(comandoCliente);
	}
	
}
