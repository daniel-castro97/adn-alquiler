package com.ceiba.alquiler.servicio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.ceiba.alquiler.aplicacion.comando.ComandoReserva;
import com.ceiba.alquiler.dataBuilder.ComandoReservaTestDatabuilder;
import com.ceiba.alquiler.dominio.repositorio.RepositorioReserva;
import com.ceiba.alquiler.dominio.servicio.reserva.ServicioListarReserva;

public class ServicioListarReservaTest {
	
	@Test
	public void listar() {
		List<ComandoReserva> list = new ArrayList<>();
		list.add(new ComandoReservaTestDatabuilder().build());
		RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
		Mockito.when(repositorioReserva.listar()).thenReturn(list);
		ServicioListarReserva listarReserva = new ServicioListarReserva(repositorioReserva);
		assertEquals(listarReserva.listar().size(), 1);
	}

}
