package com.ceiba.alquiler.infraestructura.configuracion.moto;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ceiba.alquiler.dominio.repositorio.RepositorioMoto;
import com.ceiba.alquiler.dominio.servicio.moto.ServicioActualizarMoto;

@Configuration
public class ServicioBeanActualizarMoto {

	@Bean
	public ServicioActualizarMoto actualizarServicioBean(RepositorioMoto repositorioMoto) {
		return new ServicioActualizarMoto(repositorioMoto);
	}
}
