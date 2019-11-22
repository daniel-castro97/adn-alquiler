package com.ceiba.alquiler.aplicacion.comando.manejador.cliente;

import org.springframework.stereotype.Component;

import com.ceiba.alquiler.dominio.servicio.cliente.ServicioEliminarCliente;

@Component
public class ManejadorEliminarCliente {
	
	private final ServicioEliminarCliente servicioEliminarCliente;

	public ManejadorEliminarCliente(ServicioEliminarCliente servicioEliminarCliente) {
		
		this.servicioEliminarCliente = servicioEliminarCliente;
	}
	
		public void eliminar(Long cedula) {
			this.servicioEliminarCliente.elimiar(cedula);
		}

}