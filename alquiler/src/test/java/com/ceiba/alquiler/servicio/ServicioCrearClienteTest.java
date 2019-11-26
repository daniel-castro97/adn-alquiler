package com.ceiba.alquiler.servicio;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.ceiba.alquiler.BasePrueba;
import com.ceiba.alquiler.dataBuilder.ClienteTestDataBuilder;
import com.ceiba.alquiler.dominio.entidades.Cliente;
import com.ceiba.alquiler.dominio.excepcion.ExcepcionClienteExiste;
import com.ceiba.alquiler.dominio.repositorio.RepositorioCliente;
import com.ceiba.alquiler.dominio.servicio.cliente.ServicioCrearCliente;

public class ServicioCrearClienteTest {
	
	@Test
	public void validarExistenciaPrevia() {
		Cliente cliente = new ClienteTestDataBuilder().build();
		RepositorioCliente repositorioCliente = Mockito.mock(RepositorioCliente.class);
		Mockito.when(repositorioCliente.existe(Mockito.any())).thenReturn(true);
		
		ServicioCrearCliente servicioCrearCliente = new ServicioCrearCliente(repositorioCliente);
		BasePrueba.assertThrows(() -> servicioCrearCliente.crear(cliente), ExcepcionClienteExiste.class, "El cliente ya se encuentra registrado");
	}
}
