package com.ceiba.alquiler.infraestructura.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.alquiler.aplicacion.comando.ComandoMoto;
import com.ceiba.alquiler.aplicacion.comando.manejador.moto.ManejadorActualizarMoto;
import com.ceiba.alquiler.aplicacion.comando.manejador.moto.ManejadorCrearMoto;
import com.ceiba.alquiler.aplicacion.comando.manejador.moto.ManejadorEliminarMoto;

/**
 * 
 * @author daniel.castro
 *
 */

@RestController
@RequestMapping("/service")
public class MotoController {
	private final ManejadorCrearMoto manejadorMoto;
	
	private final ManejadorActualizarMoto manejadorActualizarMoto;
	
	private final ManejadorEliminarMoto manejadorEliminarMoto;
	
	public MotoController(ManejadorCrearMoto manejadorMoto, ManejadorEliminarMoto manejadorEliminarMoto, ManejadorActualizarMoto manejadorActualizarMoto) {
		
		
		this.manejadorMoto = manejadorMoto;
		
		this.manejadorActualizarMoto= manejadorActualizarMoto;
		
		this.manejadorEliminarMoto = manejadorEliminarMoto;
	}

	@GetMapping(path ="/moto/lista-motos")
	@ResponseBody
	public List<ComandoMoto> listarMotos(){
		return this.manejadorMoto.listar();
	}
	
	@PostMapping(value = "/moto/crear")
	public void crear(@RequestBody ComandoMoto comandoMoto) {
		this.manejadorMoto.crear(comandoMoto);
	}
	@PostMapping(value = "/moto/actualizar")
	public void actualizar(@RequestBody ComandoMoto comandoMoto) {
		this.manejadorActualizarMoto.actualizar(comandoMoto);
	}

	@DeleteMapping(value="/moto/eliminar/{placa}")
	public void eliminar(@PathVariable String placa) {
		this.manejadorEliminarMoto.eliminar(placa);
	}
}
