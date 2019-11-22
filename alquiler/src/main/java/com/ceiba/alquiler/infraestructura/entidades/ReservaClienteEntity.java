package com.ceiba.alquiler.infraestructura.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class ReservaClienteEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="reserva_id")
	private int id;
	
	@Column(name="cliente_cedula")
	private Long cedula;
}
