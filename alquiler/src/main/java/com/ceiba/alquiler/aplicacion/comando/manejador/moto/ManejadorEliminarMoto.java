package com.ceiba.alquiler.aplicacion.comando.manejador.moto;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ceiba.alquiler.dominio.entidades.Moto;
import com.ceiba.alquiler.dominio.servicio.moto.ServicioEliminarMoto;

@Component
public class ManejadorEliminarMoto {
	
	private ServicioEliminarMoto servicioEliminarMoto;

	public ManejadorEliminarMoto(ServicioEliminarMoto servicioEliminarMoto) {
		
		this.servicioEliminarMoto = servicioEliminarMoto;
	}
	@Transactional
	public void eliminar(String moto) {
		this.servicioEliminarMoto.eliminar(moto);
	}
	
}
