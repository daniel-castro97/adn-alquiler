package com.ceiba.alquiler.dominio.servicio.moto;

import com.ceiba.alquiler.aplicacion.comando.ComandoMoto;
import com.ceiba.alquiler.dominio.entidades.Moto;
import com.ceiba.alquiler.dominio.repositorio.RepositorioMoto;

public class ServicioActualizarMoto {
	
	private RepositorioMoto repositorioMoto;

	public ServicioActualizarMoto(RepositorioMoto repositorioMoto) {
		
		this.repositorioMoto = repositorioMoto;
	}
	
	public void actualizar(Moto moto) {
		ComandoMoto motoAux = buscar(moto.getPlaca());
		if(motoAux != null) {
			moto.setPlaca(motoAux.getPlaca());
			this.repositorioMoto.actualizar(moto);
		}
	}
	
	public ComandoMoto buscar(String placa) {
		return this.repositorioMoto.buscar(placa);
	}

}
