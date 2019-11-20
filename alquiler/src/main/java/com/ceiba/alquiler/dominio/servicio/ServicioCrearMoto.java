package com.ceiba.alquiler.dominio.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.alquiler.aplicacion.comando.ComandoMoto;
import com.ceiba.alquiler.dominio.entidades.Moto;
import com.ceiba.alquiler.dominio.excepcion.ExcepcionValidadorMoto;
import com.ceiba.alquiler.dominio.repositorio.RepositorioMoto;

/**
 * Servicio crear moto
 * @author daniel.castro
 *
 */
@Component
public class ServicioCrearMoto {
	
	
	private RepositorioMoto repositorioMoto;
	
	
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
			throw new ExcepcionValidadorMoto("");
		}
	}
	
	
	public void eliminar(String placa) {
		this.repositorioMoto.eliminar(placa);
	}
	
	public List<ComandoMoto> listar(){
		return this.repositorioMoto.listar();
	}
	

}
