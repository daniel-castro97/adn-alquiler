package com.ceiba.alquiler.aplicacion.comando.manejador.moto;

import org.springframework.stereotype.Component;

import com.ceiba.alquiler.aplicacion.comando.fabrica.FabricaMoto;
import com.ceiba.alquiler.dominio.entidades.Moto;
import com.ceiba.alquiler.dominio.servicio.moto.ServicioActualizarMoto;

@Component
public class ManejadorActualizarMoto {
	private final ServicioActualizarMoto actualizarMoto;
	
	private final FabricaMoto fabricaMoto;

	public ManejadorActualizarMoto(ServicioActualizarMoto actualizarMoto, FabricaMoto fabricaMoto) {
		
		this.actualizarMoto = actualizarMoto;
		this.fabricaMoto = fabricaMoto;
	}
	
	public void actualizar (Moto moto) {
		this.actualizarMoto.actualizar(moto);
	}
}
