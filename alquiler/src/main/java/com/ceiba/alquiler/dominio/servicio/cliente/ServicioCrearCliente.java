package com.ceiba.alquiler.dominio.servicio.cliente;

import com.ceiba.alquiler.dominio.entidades.Cliente;
import com.ceiba.alquiler.dominio.excepcion.ExcepcionClienteExiste;
import com.ceiba.alquiler.dominio.repositorio.RepositorioCliente;

public class ServicioCrearCliente {
	
	private static final String EL_CLIENTE_EXISTE = "El cliente ya se encuentra registrado";

	private RepositorioCliente repositorioCliente;

	public ServicioCrearCliente(RepositorioCliente repositorioCliente) {
		
		this.repositorioCliente = repositorioCliente;
	}
	
	public void crear(Cliente cliente) {
		validarExistencia(cliente);
		this.repositorioCliente.crear(cliente);
	}
	
	public void validarExistencia(Cliente cliente) {
		boolean existe = this.repositorioCliente.existe(cliente);
		if(existe) {	
			throw new ExcepcionClienteExiste(EL_CLIENTE_EXISTE);
		}
	}
}
