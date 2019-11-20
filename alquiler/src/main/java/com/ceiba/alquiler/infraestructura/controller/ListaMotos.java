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

/**
 * 
 * @author daniel.castro
 *
 */
@RestController
@RequestMapping(value="/lista")
public class ListaMotos {
	private final ManejadorCrearMoto manejadorMoto;
	
	public ListaMotos(ManejadorCrearMoto manejadorMoto) {
		
		this.manejadorMoto = manejadorMoto;
	}

	@GetMapping(path ="/motos")
	@ResponseBody
	public List<ComandoMoto> listarMotos(){
		return this.manejadorMoto.listar();
	}
	
	@PostMapping(path = "/crear")
	public void crear(@RequestBody ComandoMoto comandoMoto) {
		System.err.print(comandoMoto.getModelo());
		System.err.print(comandoMoto.getPrecioAlquiler());
		this.manejadorMoto.crear(comandoMoto);
	}

}
