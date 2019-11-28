package com.ceiba.alquiler.dataBuilder;

import java.util.Date;

import com.ceiba.alquiler.aplicacion.comando.ComandoReserva;
import com.ceiba.alquiler.dominio.entidades.Cliente;
import com.ceiba.alquiler.dominio.entidades.Moto;

public class ComandoReservaTestDatabuilder{
	
	private int id;
	private Date fechaSolicitud;
	private Date fechaInicio;
	private Date fechaFin;
	private int valorTotal;
	private Moto moto;
	private Cliente cliente;
	
	public ComandoReservaTestDatabuilder() {
		this.id = 1;
		this.fechaSolicitud = new Date();
		this.fechaInicio = new Date();
		this.fechaFin = new Date();
		this.valorTotal = 50000;
		this.cliente = new ClienteTestDataBuilder().build();
		//this.cliente.setCedula(1111111111L);
		this.moto = new MotoTestDataBuilder().build();
		//this.moto.setPlaca("rhd79e");
	}

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

	public Moto getMoto() {
		return moto;
	}

	public void setMoto(Moto moto) {
		this.moto = moto;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public ComandoReserva build() {
		return new ComandoReserva(id, fechaSolicitud, fechaInicio, fechaFin, valorTotal, moto, cliente);
	}
}
