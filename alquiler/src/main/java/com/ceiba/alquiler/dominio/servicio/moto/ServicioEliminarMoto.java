package com.ceiba.alquiler.dominio.servicio.moto;

import com.ceiba.alquiler.dominio.repositorio.RepositorioMoto;

public class ServicioEliminarMoto {
	
	private RepositorioMoto repositorioMoto;
	
	
	
	public ServicioEliminarMoto(RepositorioMoto repositorioMoto) {
		
		this.repositorioMoto = repositorioMoto;
	}



	public void eliminar(String placa) {
		this.repositorioMoto.eliminar(placa);
	}

}
