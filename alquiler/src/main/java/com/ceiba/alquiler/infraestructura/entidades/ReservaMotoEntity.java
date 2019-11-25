package com.ceiba.alquiler.infraestructura.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ReservaMotoEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="id_reserva", insertable = false, updatable = false)
	private ReservaEntity idReserva;
	
	@ManyToOne
	@JoinColumn(name="placa", insertable = false, updatable = false)
	private MotoEntity placa;

	public ReservaMotoEntity() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ReservaEntity getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(ReservaEntity idReserva) {
		this.idReserva = idReserva;
	}

	public MotoEntity getPlaca() {
		return placa;
	}

	public void setPlaca(MotoEntity placa) {
		this.placa = placa;
	}
}
