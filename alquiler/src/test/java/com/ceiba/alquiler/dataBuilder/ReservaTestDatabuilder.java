package com.ceiba.alquiler.dataBuilder;

import java.util.Date;

import com.ceiba.alquiler.dominio.entidades.Cliente;
import com.ceiba.alquiler.dominio.entidades.Moto;
import com.ceiba.alquiler.dominio.entidades.Reserva;

public class ReservaTestDatabuilder {


	private int id;
	private Date fechaSolicitud;
	private Date fechaInicio;
	private Date fechaFin;
	private int valorTotal;
	private Moto moto;
	private Cliente cliente;
	
	public ReservaTestDatabuilder() {
		this.id = 1;
		this.fechaSolicitud = new Date();
		this.fechaInicio = new Date();
		this.fechaFin = new Date();
		this.valorTotal = 50000;
		this.cliente = new Cliente();
		cliente.setCedula(12345L);
		this.moto = new Moto();
		moto.setPlaca("abc12d");
	}
	
	public ReservaTestDatabuilder withFechaSolicitud(Date fecha) {
		this.fechaSolicitud = fecha;
		return this;
	}
	
	public ReservaTestDatabuilder withFechaInicio(Date fecha) {
		this.fechaInicio = fecha;
		return this;
	}
	public ReservaTestDatabuilder withFechaFin(Date fecha) {
		this.fechaFin = fecha;
		return this;
	}
	public ReservaTestDatabuilder withValorTotal(int valor) {
		this.valorTotal = valor;
		return this;
	}
	public ReservaTestDatabuilder withCliente(Cliente cliente) {
		this.cliente = cliente;
		return this;
	}
	public ReservaTestDatabuilder withMoto(Moto moto) {
		this.moto = moto;
		return this;
	}
	
	public Reserva build() {
		return new Reserva(id, fechaSolicitud, fechaInicio, fechaFin, valorTotal, moto, cliente);
	}
}
