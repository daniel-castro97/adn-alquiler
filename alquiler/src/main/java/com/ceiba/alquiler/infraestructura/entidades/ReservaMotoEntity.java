package com.ceiba.alquiler.infraestructura.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class ReservaMotoEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@Column(name="reserva_id")
	private int id;
	
	@Column(name="moto_placa")
	private String placa;
}
