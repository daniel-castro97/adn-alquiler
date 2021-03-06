package com.ceiba.alquiler.infraestructura.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class ReservaEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_reserva")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idReserva;
	
	@Column(name="fecha_solicitud")
	@Temporal(TemporalType.DATE)
	private Date fechaSolicitud;
	
	@Column(name="fecha_inicio")
	@Temporal(TemporalType.DATE)
	private Date fechaInicio;
	
	@Column(name="fecha_fin")
	@Temporal(TemporalType.DATE)
	private Date fechaFin;
	
	
	@Column(name="valor_total")
	private int valorTotal;

	
	@ManyToOne
	@JoinColumn(name="cedula", nullable = false)
	private ClienteEntity cliente;
	
	@ManyToOne
	@JoinColumn(name="placa", nullable = false)
	private MotoEntity moto;

	public Date getFechaSolicitud() {
		return fechaSolicitud;
	}

	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public int getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(int valorTotal) {
		this.valorTotal = valorTotal;
	}

	public int getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	public ClienteEntity getCliente() {
		return cliente;
	}

	public void setCliente(ClienteEntity idCliente) {
		this.cliente = idCliente;
	}

	public MotoEntity getMoto() {
		return moto;
	}

	public void setMoto(MotoEntity moto) {
		this.moto = moto;
	}

}
