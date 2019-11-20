package com.ceiba.alquiler.aplicacion.comando.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.alquiler.aplicacion.comando.ComandoMoto;
import com.ceiba.alquiler.dominio.entidades.Moto;

/**
 * Clase fabrica
 * @author daniel.castro
 *
 */
@Component
public class FabricaMoto {


	
	/**
	 * Creacion
	 * @param coomandoMoto, Comando moto
	 * @return, Moto con datos
	 */
	public Moto crearMoto(ComandoMoto comandoMoto) {
		return new Moto(comandoMoto.getPlaca(), comandoMoto.getMarca(), comandoMoto.getModelo(),
				comandoMoto.getReferencia(),comandoMoto.getCilindrada(),comandoMoto.getPrecioAlquiler());
	}

}
