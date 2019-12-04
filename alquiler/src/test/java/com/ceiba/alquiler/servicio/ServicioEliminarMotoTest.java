package com.ceiba.alquiler.servicio;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.ceiba.alquiler.BasePrueba;
import com.ceiba.alquiler.dataBuilder.MotoTestDataBuilder;
import com.ceiba.alquiler.dominio.entidades.Moto;
import com.ceiba.alquiler.dominio.excepcion.ExcepcionValidadorMoto;
import com.ceiba.alquiler.dominio.repositorio.RepositorioMoto;
import com.ceiba.alquiler.dominio.servicio.moto.ServicioEliminarMoto;

public class ServicioEliminarMotoTest {
	
	@Test
	public void existeEliminar() {
		Moto moto = new MotoTestDataBuilder().build();
		RepositorioMoto repositorioMoto = Mockito.mock(RepositorioMoto.class);
		Mockito.when(repositorioMoto.existe(Mockito.any())).thenReturn(false);
		ServicioEliminarMoto servicioEliminarMoto = new ServicioEliminarMoto(repositorioMoto);
		BasePrueba.assertThrows(() -> servicioEliminarMoto.eliminar(moto.getPlaca()), ExcepcionValidadorMoto.class, "La moto no existe");
	}

}
