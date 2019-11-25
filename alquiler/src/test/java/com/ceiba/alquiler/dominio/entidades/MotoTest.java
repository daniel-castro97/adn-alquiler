package com.ceiba.alquiler.dominio.entidades;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;

import org.junit.jupiter.api.Test;

import com.ceiba.alquiler.BasePrueba;
import com.ceiba.alquiler.dataBuilder.MotoTestDataBuilder;
import com.ceiba.alquiler.dominio.excepcion.ExcepcionValidadorMoto;
import com.ceiba.alquiler.dominio.excepcion.ExcepcionValorObligatorio;

public class MotoTest {
	
	@Test
	public void motoValidad() throws ParseException {
		boolean resultadoPruebaMoto = false;
		Moto moto = new MotoTestDataBuilder().build();
		assertEquals(160, moto.getCilindrada());
		
	}
	
	@Test
	public void validarTamanioPlaca() {
		MotoTestDataBuilder builder = new MotoTestDataBuilder(); 
		builder.withPlaca("rhd");
		BasePrueba.assertThrows(() -> builder.build(), ExcepcionValidadorMoto.class, "La placa debe tener minimo 6 caracteres");
	}
	
	@Test
	public void validarCampoObligatorio() {
		MotoTestDataBuilder builder = new MotoTestDataBuilder();
		builder.withReferencia(null);
		BasePrueba.assertThrows(() -> builder.build(), ExcepcionValorObligatorio.class, "La referencia es un campo obligatorio");
	}
}
