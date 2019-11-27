package com.ceiba.alquiler.dominio.servicio.cliente;

import com.ceiba.alquiler.dominio.entidades.Cliente;
import com.ceiba.alquiler.dominio.excepcion.ExcepcionValidadorMoto;
import com.ceiba.alquiler.dominio.repositorio.RepositorioCliente;

public class ServicioEliminarCliente {
	
	RepositorioCliente repositorioCliente;
	
	private static final String CLIENTE_NO_EXISTE = "El cliente no existe";

	public ServicioEliminarCliente(RepositorioCliente repositorioCliente) {

		this.repositorioCliente = repositorioCliente;
	}
	
	public void elimiar(Cliente cliente) {
		existeCliente(cliente);
		this.repositorioCliente.eliminar(cliente);
	}
	
	public void existeCliente(Cliente cliente) {
		boolean existe = repositorioCliente.existe(cliente);
		if(!existe) {
			throw new ExcepcionValidadorMoto(CLIENTE_NO_EXISTE);
		}
	}

}
