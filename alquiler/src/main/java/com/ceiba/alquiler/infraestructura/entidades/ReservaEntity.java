package com.ceiba.alquiler.infraestructura.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class ReservaEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
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
	
	@Column(name="moto_placa")
	private String  moto;
	
	@Column(name="cliente_id")
	private int cliente;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public String getMoto() {
		return moto;
	}

	public void setMoto(String moto) {
		this.moto = moto;
	}

	public int getCliente() {
		return cliente;
	}

	public void setCliente(int cliente) {
		this.cliente = cliente;
	}

}
