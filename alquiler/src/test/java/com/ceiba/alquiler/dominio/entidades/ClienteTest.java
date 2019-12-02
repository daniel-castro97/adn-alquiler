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
	public void validarCedula() {
		ClienteTestDataBuilder builder = new ClienteTestDataBuilder();
		builder.withCedula(null);
		BasePrueba.assertThrows(() -> builder.build(), ExcepcionValorObligatorio.class, "La cedula es un campo obligatorio");
	}
	
	@Test
	public void validarNombre() {
		ClienteTestDataBuilder builder = new ClienteTestDataBuilder();
		builder.withNombre(null);
		BasePrueba.assertThrows(() -> builder.build(), ExcepcionValorObligatorio.class, "El nombre es un campo obligatorio");
	}
	
//	@Test
//	public void validarFecha() {
//		ClienteTestDataBuilder builder = new ClienteTestDataBuilder();
//		builder.withFechaNacimiento(null);
//		BasePrueba.assertThrows(() -> builder.build(), ExcepcionValorObligatorio.class, "La fecha de nacimiento es un campo obligatorio");
//	}
	
	@Test
	public void validarCorreo() {
		ClienteTestDataBuilder builder = new ClienteTestDataBuilder();
		builder.withCorreo(null);
		BasePrueba.assertThrows(() -> builder.build(), ExcepcionValorObligatorio.class, "El correo electronico es un campo obligatorio");
	}
}
