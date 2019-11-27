package com.ceiba.alquiler.infraestructura.configuracion.reserva;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ceiba.alquiler.dominio.repositorio.RepositorioReserva;
import com.ceiba.alquiler.dominio.servicio.reserva.ServicioListarReserva;

@Configuration
public class ServicioBeanListarReserva {
	@Bean
	public ServicioListarReserva listarServicioReservaBean(RepositorioReserva repositorioReserva) {
		return new ServicioListarReserva(repositorioReserva);
	}
}
