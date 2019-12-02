package com.ceiba.alquiler.dominio.servicio.reserva;

import java.text.ParseException;

import com.ceiba.alquiler.dominio.entidades.CalcularPrecio;
import com.ceiba.alquiler.dominio.entidades.Reserva;
import com.ceiba.alquiler.dominio.entidades.ValidarFecha;
import com.ceiba.alquiler.dominio.excepcion.ExcepcionFecha;
import com.ceiba.alquiler.dominio.repositorio.RepositorioReserva;

public class ServicioCrearReserva {

	private RepositorioReserva repositorioReserva;
	
	private ValidarFecha validarFecha;
	
	private CalcularPrecio calcularPrecio;
	
	private int precioTotal;
	
	private static final String DIA_NO_DISPONIBLE = "No se aceptan solicitudes los Domingos";

	public ServicioCrearReserva(RepositorioReserva repositorioReserva) {
		
		this.repositorioReserva = repositorioReserva;
		this.validarFecha = new ValidarFecha();
		this.calcularPrecio = new CalcularPrecio();
	}
	
	public void crear(Reserva reserva) throws ParseException {
		validarFechaSolicitud(reserva);
		validarFechaInicio(reserva);
		precioTotal = precioReserva(reserva);
		this.repositorioReserva.crear(reserva);
		reserva.setValorTotal(precioTotal);
	}
	
	public void validarFechaSolicitud(Reserva reserva){
		if(validarFecha.determinarDia(reserva.getFechaSolicitud()).equals("Domingo")){
			throw new ExcepcionFecha(DIA_NO_DISPONIBLE);
		}
	}
	
	public void validarFechaInicio(Reserva reserva) {
		if(validarFecha.determinarDia(reserva.getFechaSolicitud()).equals("Domingo")) {
			reserva.setFechaInicio(validarFecha.siguienteHabil(reserva.getFechaInicio(), 1));
		}
		else if(validarFecha.determinarDia(reserva.getFechaSolicitud()).equals("Sabado")) {
			reserva.setFechaInicio(validarFecha.siguienteHabil(reserva.getFechaInicio(), 2));
		}
	}
	
	public int precioReserva(Reserva reserva) throws ParseException {
		return calcularPrecio.calcularPrecioReserva(
				reserva.getFechaInicio(), 
				reserva.getFechaFin(),
				reserva.getMoto().getPrecioAlquiler(),
				reserva.getMoto().getCilindrada());
	}
	
}
