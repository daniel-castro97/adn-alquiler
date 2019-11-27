package com.ceiba.alquiler.servicio;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.ceiba.alquiler.BasePrueba;
import com.ceiba.alquiler.dataBuilder.ClienteTestDataBuilder;
import com.ceiba.alquiler.dominio.entidades.Cliente;
import com.ceiba.alquiler.dominio.excepcion.ExcepcionValidadorMoto;
import com.ceiba.alquiler.dominio.repositorio.RepositorioCliente;
import com.ceiba.alquiler.dominio.servicio.cliente.ServicioEliminarCliente;

public class ServicioEliminarClienteTest {
	@Test
	public void existeEliminar() {
		Cliente cliente = new ClienteTestDataBuilder().build();
		RepositorioCliente repositorioCliente = Mockito.mock(RepositorioCliente.class);
		Mockito.when(repositorioCliente.existe(Mockito.any())).thenReturn(false);
		ServicioEliminarCliente servicioEliminarCliente = new ServicioEliminarCliente(repositorioCliente);
		BasePrueba.assertThrows(() -> servicioEliminarCliente.elimiar(cliente), ExcepcionValidadorMoto.class, "El cliente no existe");
	}

}
