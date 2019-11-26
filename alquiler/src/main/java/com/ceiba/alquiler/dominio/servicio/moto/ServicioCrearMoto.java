package com.ceiba.alquiler.dominio.servicio.moto;

import java.util.List;

import com.ceiba.alquiler.aplicacion.comando.ComandoMoto;
import com.ceiba.alquiler.dominio.entidades.Moto;
import com.ceiba.alquiler.dominio.excepcion.ExcepcionValidadorMoto;
import com.ceiba.alquiler.dominio.repositorio.RepositorioMoto;

/**
 * Servicio crear moto
 * @author daniel.castro
 *
 */
//@Component
public class ServicioCrearMoto {
	
	
	private RepositorioMoto repositorioMoto;
	
	private static final String LA_MOTO_EXISTE = "La moto ya se encuentra registrada";
	
	
	public ServicioCrearMoto(RepositorioMoto repositorioMoto) {
		this.repositorioMoto = repositorioMoto;
	}

	public void crear(Moto moto) {
		validarExistencia(moto);
		this.repositorioMoto.crear(moto);
	}
	
	private void validarExistencia(Moto moto) {
		boolean existe = this.repositorioMoto.existe(moto);
		if(existe) {
			throw new ExcepcionValidadorMoto(LA_MOTO_EXISTE);
		}
	}
	
	public List<ComandoMoto> listar(){
		return this.repositorioMoto.listar();
	}
	

}
