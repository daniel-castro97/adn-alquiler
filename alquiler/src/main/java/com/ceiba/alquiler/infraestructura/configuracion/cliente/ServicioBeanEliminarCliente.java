package com.ceiba.alquiler.infraestructura.configuracion.cliente;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ceiba.alquiler.dominio.repositorio.RepositorioCliente;
import com.ceiba.alquiler.dominio.servicio.cliente.ServicioEliminarCliente;

@Configuration
public class ServicioBeanEliminarCliente {
	@Bean
	public ServicioEliminarCliente eliminarServicioClienteBean(RepositorioCliente repositorioCliente) {
		return new ServicioEliminarCliente(repositorioCliente);
	}
}
