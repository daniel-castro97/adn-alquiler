package com.ceiba.alquiler.dominio.entidades;

import org.junit.jupiter.api.Test;

import com.ceiba.alquiler.BasePrueba;
import com.ceiba.alquiler.dataBuilder.ReservaTestDatabuilder;
import com.ceiba.alquiler.dominio.excepcion.ExcepcionValorObligatorio;

public class ReservaTest {
	
	@Test
	public void validarFechaInicio() {
		ReservaTestDatabuilder databuilder = new ReservaTestDatabuilder();
		databuilder.withFechaInicio(null);
		BasePrueba.assertThrows(() -> databuilder.build(), ExcepcionValorObligatorio.class, "La fecha de inicio de la reserva para el alquiler es obligatoria");
	}
	@Test
	public void validarFechaFin() {
		ReservaTestDatabuilder databuilder = new ReservaTestDatabuilder();
		databuilder.withFechaFin(null);
		BasePrueba.assertThrows(() -> databuilder.build(), ExcepcionValorObligatorio.class, "La fecha de finalizacion de la reserva para alquiler es obligatoria");
	}
	@Test
	public void validarCliente() {
		ReservaTestDatabuilder databuilder = new ReservaTestDatabuilder();
		databuilder.withCliente(null);
		BasePrueba.assertThrows(() -> databuilder.build(), ExcepcionValorObligatorio.class, "El cliente es obligatorio");
	}
	@Test
	public void validarMoto() {
		ReservaTestDatabuilder databuilder = new ReservaTestDatabuilder();
		databuilder.withMoto(null);
		BasePrueba.assertThrows(() -> databuilder.build(), ExcepcionValorObligatorio.class, "La moto es obligatoria");
	}

}
