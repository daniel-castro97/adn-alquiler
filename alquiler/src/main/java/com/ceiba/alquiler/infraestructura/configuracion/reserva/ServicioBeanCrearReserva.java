package com.ceiba.alquiler.infraestructura.configuracion.reserva;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ceiba.alquiler.dominio.repositorio.RepositorioMoto;
import com.ceiba.alquiler.dominio.repositorio.RepositorioReserva;
import com.ceiba.alquiler.dominio.servicio.reserva.ServicioCrearReserva;

@Configuration
public class ServicioBeanCrearReserva {
	@Bean
	public ServicioCrearReserva crearServicioReservaBean(RepositorioReserva repositorioReserva, RepositorioMoto moto) {
		return new ServicioCrearReserva(repositorioReserva, moto);
	}
}
