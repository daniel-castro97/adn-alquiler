package com.ceiba.alquiler.aplicacion.comando.manejador.moto;

import org.springframework.stereotype.Component;

import com.ceiba.alquiler.dominio.servicio.moto.ServicioEliminarMoto;

@Component
public class ManejadorEliminarMoto {
	
	private ServicioEliminarMoto servicioEliminarMoto;

	public ManejadorEliminarMoto(ServicioEliminarMoto servicioEliminarMoto) {
		
		this.servicioEliminarMoto = servicioEliminarMoto;
	}
	 
	public void eliminar(String placa) {
		this.servicioEliminarMoto.eliminar(placa);
	}
	
}
