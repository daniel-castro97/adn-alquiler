package com.ceiba.alquiler.infraestructura.configuracion.moto;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ceiba.alquiler.dominio.repositorio.RepositorioMoto;
import com.ceiba.alquiler.dominio.servicio.moto.ServicioCrearMoto;

@Configuration
public class ServicioBean {
	@Bean
	public ServicioCrearMoto crearServicioMotoBean (RepositorioMoto repositorioMoto) {
		return new ServicioCrearMoto(repositorioMoto);
	}
}
