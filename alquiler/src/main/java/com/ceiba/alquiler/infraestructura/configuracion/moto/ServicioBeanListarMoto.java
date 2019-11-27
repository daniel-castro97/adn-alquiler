package com.ceiba.alquiler.infraestructura.configuracion.moto;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ceiba.alquiler.dominio.repositorio.RepositorioMoto;
import com.ceiba.alquiler.dominio.servicio.moto.ServicioListarMoto;

@Configuration
public class ServicioBeanListarMoto {
	@Bean
	public ServicioListarMoto listarServicioMotoBean(RepositorioMoto repositorioMoto) {
		return new ServicioListarMoto(repositorioMoto);
	}
}
