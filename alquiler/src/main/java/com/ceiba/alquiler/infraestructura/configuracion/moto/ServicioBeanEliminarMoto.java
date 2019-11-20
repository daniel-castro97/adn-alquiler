package com.ceiba.alquiler.infraestructura.configuracion.moto;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ceiba.alquiler.dominio.repositorio.RepositorioMoto;
import com.ceiba.alquiler.dominio.servicio.moto.ServicioEliminarMoto;

@Configuration
public class ServicioBeanEliminarMoto {
	@Bean
	public ServicioEliminarMoto eliminarServicioMotoBean(RepositorioMoto repositorioMoto) {
		return new ServicioEliminarMoto(repositorioMoto);
	}
}
