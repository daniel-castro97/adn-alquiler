package com.ceiba.alquiler.dominio.entidades;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Clase que define los atributos del objeto reserva
 * @author daniel.castro
 *
 */

@Getter
@Setter
@NoArgsConstructor
public class Reserva {
	
	private static final String LA_FECHA_INICIO_ES_OBLIGATORIA ="La fecha de inicio de la reserva para el alquiler es obligatoria";
	private static final String LA_FECHA_FIN_ES_OBLIGATORIA = "La fecha de finalizacion de la reserva para alquiler es obligatoria";
	private static final String LA_MOTO_ES_OBLIGATORIA = "La moto es obligatoria";
	private static final String EL_CLIENTE_ES_OBLIGATORIO = "El cliente es obligatorio";
	
	
	private int id;
	private Date fechaSolicitud;
	private Date fechaInicio;
	private Date fechaFin;
	private int valorTotal;
	private Moto moto;
	private Cliente cliente;
	
	/**
	 * Constructor
	 * @param id
	 * @param fechaSolicitud
	 * @param fechaInicio
	 * @param fechaFin
	 * @param valorTotal
	 * @param moto
	 * @param cliente
	 */
	public Reserva(int id, Date fechaSolicitud, Date fechaInicio, Date fechaFin, int valorTotal, Moto moto,
			Cliente cliente) {
		ValidadorReserva.validarObligatorio(fechaInicio, LA_FECHA_INICIO_ES_OBLIGATORIA);
		ValidadorReserva.validarObligatorio(fechaFin, LA_FECHA_FIN_ES_OBLIGATORIA);
		ValidadorReserva.validarObligatorio(cliente, EL_CLIENTE_ES_OBLIGATORIO);
		ValidadorReserva.validarObligatorio(moto, LA_MOTO_ES_OBLIGATORIA);
		this.id = id;
		this.fechaSolicitud = fechaSolicitud;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.valorTotal = valorTotal;
		this.moto = moto;
		this.cliente = cliente;
	}
}
