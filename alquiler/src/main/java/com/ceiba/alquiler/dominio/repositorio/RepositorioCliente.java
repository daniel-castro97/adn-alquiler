package com.ceiba.alquiler.dominio.repositorio;

import java.util.List;

import com.ceiba.alquiler.aplicacion.comando.ComandoCliente;
import com.ceiba.alquiler.dominio.entidades.Cliente;
/**
 * 
 * @author daniel.castro
 *
 */
public interface RepositorioCliente {
	
	/**
	 * Metodo para crear Cliente
	 * @param cliente, cliente a crear
	 */
	void crear(Cliente cliente);
	
	
	/**
	 * Metodo para verificar si existe un cliente
	 * @param cliente, cliente a cerificar
	 */
	boolean existe(Cliente cliente);
	/**
	 * Metodo para eliminar cliente por medio de su cedula
	 * @param cedula, cedula a consultar para eliminar el cliente
	 */
	void eliminar(Cliente cliente);
	
	/**
	 * Metodo que retorna la lista de cliente
	 * @return lista de clientes
	 */
	List<ComandoCliente> listar();
	/**
	 * Metodo para buscar un cliente por su cedula
	 * @param cedula, cedula a buscar
	 * @return Cliente encontrado
	 */
	ComandoCliente buscar(int cedula);
}
