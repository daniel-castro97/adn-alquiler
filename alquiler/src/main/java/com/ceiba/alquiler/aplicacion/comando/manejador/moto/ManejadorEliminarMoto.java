package com.ceiba.alquiler.aplicacion.comando.manejador.moto;

import org.springframework.stereotype.Component;

import com.ceiba.alquiler.dominio.entidades.Moto;
import com.ceiba.alquiler.dominio.servicio.moto.ServicioEliminarMoto;

@Component
public class ManejadorEliminarMoto {
	
	private ServicioEliminarMoto servicioEliminarMoto;

	public ManejadorEliminarMoto(ServicioEliminarMoto servicioEliminarMoto) {
		
		this.servicioEliminarMoto = servicioEliminarMoto;
	}
	 
	public void eliminar(Moto moto) {
		this.servicioEliminarMoto.eliminar(moto);
	}
	
}
