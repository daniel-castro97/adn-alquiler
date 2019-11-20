package com.ceiba.alquiler.infraestructura.adaptador.servicio;

import org.springframework.context.annotation.Configuration;

import com.ceiba.alquiler.dominio.repositorio.RepositorioMoto;
import com.ceiba.alquiler.dominio.servicio.ServicioCrearMoto;

/**
 * Bean servicio
 * @author daniel.castro
 *
 */
@Configuration
public class BeanServicio {

	public ServicioCrearMoto servicioCrearMoto(RepositorioMoto repositorioMoto) {
		return new ServicioCrearMoto(repositorioMoto);
	}


}
