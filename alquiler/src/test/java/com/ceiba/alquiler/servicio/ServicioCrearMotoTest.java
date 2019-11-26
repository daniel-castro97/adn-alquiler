package com.ceiba.alquiler.servicio;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.ceiba.alquiler.BasePrueba;
import com.ceiba.alquiler.dataBuilder.MotoTestDataBuilder;
import com.ceiba.alquiler.dominio.entidades.Moto;
import com.ceiba.alquiler.dominio.excepcion.ExcepcionValidadorMoto;
import com.ceiba.alquiler.dominio.repositorio.RepositorioMoto;
import com.ceiba.alquiler.dominio.servicio.moto.ServicioCrearMoto;

public class ServicioCrearMotoTest {
	
	@Test
	public void validarExistencia() {
		Moto moto = new MotoTestDataBuilder().build();
		RepositorioMoto repositorioMoto= Mockito.mock(RepositorioMoto.class);
		Mockito.when(repositorioMoto.existe(moto)).thenReturn(true);
		
		ServicioCrearMoto servicioCrearMoto = new ServicioCrearMoto(repositorioMoto);
		BasePrueba.assertThrows(() -> servicioCrearMoto.crear(moto), ExcepcionValidadorMoto.class, "La moto ya se encuentra registrada");
	}

}
