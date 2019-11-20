package com.ceiba.alquiler.infraestructura.configuracion.cliente;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ceiba.alquiler.dominio.repositorio.RepositorioCliente;
import com.ceiba.alquiler.dominio.servicio.cliente.ServicioCrearCliente;

@Configuration
public class ServicioBeanCrearCliente {
	@Bean
	public ServicioCrearCliente crearServicioClienteBean(RepositorioCliente repositorioCliente) {
		return new ServicioCrearCliente(repositorioCliente);
	}
}
