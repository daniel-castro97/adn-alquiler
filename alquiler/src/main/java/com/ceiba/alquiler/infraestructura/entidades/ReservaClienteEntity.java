package com.ceiba.alquiler.infraestructura.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ReservaClienteEntity implements Serializable{

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
	@JoinColumn(name="cedula", insertable = false, updatable = false)
	private ClienteEntity idCliente;

	public ReservaClienteEntity() {
	
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

	public ClienteEntity getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(ClienteEntity idCliente) {
		this.idCliente = idCliente;
	}
	
	
}
