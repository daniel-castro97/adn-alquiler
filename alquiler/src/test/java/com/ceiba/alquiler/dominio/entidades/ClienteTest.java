package com.ceiba.alquiler.dominio.entidades;

import org.junit.jupiter.api.Test;

import com.ceiba.alquiler.BasePrueba;
import com.ceiba.alquiler.dataBuilder.ClienteTestDataBuilder;
import com.ceiba.alquiler.dominio.excepcion.ExcepcionValidarPase;
import com.ceiba.alquiler.dominio.excepcion.ExcepcionValorObligatorio;

public class ClienteTest {
	
	@Test
	public void validarPase() {
		ClienteTestDataBuilder builder = new ClienteTestDataBuilder();
		builder.withPase("A");
		BasePrueba.assertThrows(() -> builder.build(), ExcepcionValidarPase.class, "El pase debe tener minimo dos caracteres");
	}
	
	@Test
	public void validarObligatorio() {
		ClienteTestDataBuilder builder = new ClienteTestDataBuilder();
		builder.withCedula(null);
		BasePrueba.assertThrows(() -> builder.build(), ExcepcionValorObligatorio.class, "La cedula es un campo obligatorio");
	}
}
