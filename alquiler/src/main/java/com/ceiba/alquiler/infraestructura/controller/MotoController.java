package com.ceiba.alquiler.infraestructura.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.alquiler.aplicacion.comando.ComandoMoto;
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
	
	public MotoController(ManejadorCrearMoto manejadorMoto, ManejadorEliminarMoto manejadorEliminarMoto) {
		
		
		this.manejadorMoto = manejadorMoto;
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

}
