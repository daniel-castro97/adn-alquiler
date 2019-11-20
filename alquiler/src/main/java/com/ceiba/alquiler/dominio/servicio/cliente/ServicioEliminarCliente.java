package com.ceiba.alquiler.dominio.servicio.cliente;

import com.ceiba.alquiler.dominio.repositorio.RepositorioCliente;

public class ServicioEliminarCliente {
	
	RepositorioCliente repositorioCliente;

	public ServicioEliminarCliente(RepositorioCliente repositorioCliente) {

		this.repositorioCliente = repositorioCliente;
	}
	
	public void elimiar(Long cedula) {
		this.repositorioCliente.eliminar(cedula);
	}

}
