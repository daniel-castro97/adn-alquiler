package com.ceiba.alquiler.aplicacion.comando.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.alquiler.aplicacion.comando.ComandoCliente;
import com.ceiba.alquiler.dominio.entidades.Cliente;

@Component
public class FabricaCliente {

	public Cliente crearCliente(ComandoCliente comandoCliente){
		return new Cliente(comandoCliente.getCedula(), comandoCliente.getNombre(), comandoCliente.getFechaNacimineto(),
				comandoCliente.getTelefono(), comandoCliente.getCorreo(), comandoCliente.getCategoriaPase());
	}
}
