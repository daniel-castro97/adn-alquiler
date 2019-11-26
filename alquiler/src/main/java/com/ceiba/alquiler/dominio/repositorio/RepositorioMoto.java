package com.ceiba.alquiler.dominio.repositorio;

import java.util.List;

import com.ceiba.alquiler.aplicacion.comando.ComandoMoto;
import com.ceiba.alquiler.dominio.entidades.Moto;

/**
 * Interface de repositorio moto
 * @author daniel.castro
 *
 */
public interface RepositorioMoto {
	/**
	 * 
	 * @param Moto
	 */
	void crear(Moto moto);
	/**
	 * 
	 * @param moto
	 * @return
	 */
	boolean existe(Moto moto);
	/**
	 * 
	 * @param placa
	 */
	void eliminar(String placa);
	
	
	/**
	 * 
	 * @param moto
	 */
	void actualizar(Moto moto);
	
	/**
	 * 
	 * @return
	 */
	List<ComandoMoto> listar();
	/**
	 * 
	 * @param placa
	 * @return
	 */
	ComandoMoto buscar(String placa);

}
