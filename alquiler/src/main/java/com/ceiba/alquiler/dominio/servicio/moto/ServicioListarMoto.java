package com.ceiba.alquiler.dominio.servicio.moto;

import java.util.List;

import com.ceiba.alquiler.aplicacion.comando.ComandoMoto;
import com.ceiba.alquiler.dominio.repositorio.RepositorioMoto;

public class ServicioListarMoto {
	
	private RepositorioMoto repositorioMoto;

	public ServicioListarMoto(RepositorioMoto repositorioMoto) {
		this.repositorioMoto = repositorioMoto;
	}
	
	public List<ComandoMoto> listar(){
		return repositorioMoto.listar();
	}
	
}
