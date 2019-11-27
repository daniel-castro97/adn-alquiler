package com.ceiba.alquiler.dominio.repositorio;

import java.util.List;

import com.ceiba.alquiler.aplicacion.comando.ComandoReserva;
import com.ceiba.alquiler.dominio.entidades.Reserva;

/**
 * Interface con las funcionalidades de la clase Reserva
 * @author daniel.castro
 *
 */
public interface RepositorioReserva {
	/**
	 * Metodo crear
	 * @param reserva
	 */
	void crear(Reserva reserva);
	/**
	 * metodo para validar la exitencia de una reserva
	 * @param reserva, reserva a validar
	 * @return
	 */
	boolean existe(Reserva reserva);
	
	/**
	 * Metodo para listar las reservas
	 * @return
	 */
	List<ComandoReserva> listar();
	/**
	 * Metodo para buscar una reserva
	 * @param id
	 * @return
	 */
	ComandoReserva buscar(int id);

}
