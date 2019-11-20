package com.ceiba.alquiler.aplicacion.comando.manejador.cliente;

import org.springframework.stereotype.Component;

import com.ceiba.alquiler.aplicacion.comando.ComandoCliente;
import com.ceiba.alquiler.aplicacion.comando.fabrica.FabricaCliente;
import com.ceiba.alquiler.dominio.entidades.Cliente;
import com.ceiba.alquiler.dominio.servicio.cliente.ServicioCrearCliente;

@Component
public class ManejadorCrearCliente {

	private final ServicioCrearCliente servicioCrearCliente;
	
	private final FabricaCliente fabricaCliente;

	public ManejadorCrearCliente(ServicioCrearCliente servicioCrearCliente, FabricaCliente fabricaCliente) {
		super();
		this.servicioCrearCliente = servicioCrearCliente;
		this.fabricaCliente = fabricaCliente;
	}
	
	public void crear(ComandoCliente comandoCliente) {
		Cliente cliente = this.fabricaCliente.crearCliente(comandoCliente);
		servicioCrearCliente.crear(cliente);
	}
	
}
