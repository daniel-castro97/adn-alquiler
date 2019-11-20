package com.ceiba.alquiler.dominio.servicio.cliente;

import com.ceiba.alquiler.dominio.entidades.Cliente;
import com.ceiba.alquiler.dominio.excepcion.ExcepcionValidadorMoto;
import com.ceiba.alquiler.dominio.repositorio.RepositorioCliente;

public class ServicioCrearCliente {

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
			//CAMBIAR POR EXCPECION CLIENTE - SOLO ES UNA PRUEBA
			throw new ExcepcionValidadorMoto("El cliente ya existe");
		}
	}
}
