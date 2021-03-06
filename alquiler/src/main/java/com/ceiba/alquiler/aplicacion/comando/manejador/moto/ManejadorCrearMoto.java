package com.ceiba.alquiler.aplicacion.comando.manejador.moto;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.alquiler.aplicacion.comando.ComandoMoto;
import com.ceiba.alquiler.aplicacion.comando.fabrica.FabricaMoto;
import com.ceiba.alquiler.dominio.entidades.Moto;
import com.ceiba.alquiler.dominio.servicio.moto.ServicioCrearMoto;

@Component
public class ManejadorCrearMoto {
	/*
	 * Atributos
	 */
	private final ServicioCrearMoto servicioCrearMoto;
	
	private final FabricaMoto fabricaMoto;
	/**
	 * Constructir
	 * @param servicioCrearMoto
	 * @param fabricaMoto
	 */
	public ManejadorCrearMoto(ServicioCrearMoto servicioCrearMoto, FabricaMoto fabricaMoto) {
		this.servicioCrearMoto = servicioCrearMoto;
		this.fabricaMoto = fabricaMoto;
	}
	
	public void crear(ComandoMoto coomandoMoto) {
		Moto moto = this.fabricaMoto.crearMoto(coomandoMoto);
		this.servicioCrearMoto.crear(moto);
	}
	
	public List<ComandoMoto> listar(){
		return this.servicioCrearMoto.listar();
	}

}
