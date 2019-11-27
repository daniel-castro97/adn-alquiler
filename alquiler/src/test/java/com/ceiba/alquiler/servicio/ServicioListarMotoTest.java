package com.ceiba.alquiler.servicio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.ceiba.alquiler.aplicacion.comando.ComandoMoto;
import com.ceiba.alquiler.dataBuilder.ComandoMotoTestDatabuilder;
import com.ceiba.alquiler.dominio.repositorio.RepositorioMoto;
import com.ceiba.alquiler.dominio.servicio.moto.ServicioListarMoto;

public class ServicioListarMotoTest {
	
	@Test
	public void listar() {
		List<ComandoMoto> list = new ArrayList<>();
		list.add(new ComandoMotoTestDatabuilder().build());
		RepositorioMoto repositorioMoto = Mockito.mock(RepositorioMoto.class);
		Mockito.when(repositorioMoto.listar()).thenReturn(list);
		ServicioListarMoto servicioListarMoto = new ServicioListarMoto(repositorioMoto);
		assertEquals(servicioListarMoto.listar().size(), 1);
	}
}
