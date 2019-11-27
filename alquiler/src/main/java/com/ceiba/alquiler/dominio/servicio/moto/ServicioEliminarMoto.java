package com.ceiba.alquiler.dominio.servicio.moto;

import com.ceiba.alquiler.dominio.entidades.Moto;
import com.ceiba.alquiler.dominio.excepcion.ExcepcionValidadorMoto;
import com.ceiba.alquiler.dominio.repositorio.RepositorioMoto;

public class ServicioEliminarMoto {
	
	private RepositorioMoto repositorioMoto;
	
	private static final String MOTO_NO_EXISTE = "La moto no existe";
	
	public ServicioEliminarMoto(RepositorioMoto repositorioMoto) {
		
		this.repositorioMoto = repositorioMoto;
	}
	



	public void eliminar(Moto moto) {
		existeMoto(moto);
		this.repositorioMoto.eliminar(moto);
	}
	
	public void existeMoto(Moto moto) {
		boolean existe = repositorioMoto.existe(moto);
		if(!existe) {
			throw new ExcepcionValidadorMoto(MOTO_NO_EXISTE);
		}
	}

}
