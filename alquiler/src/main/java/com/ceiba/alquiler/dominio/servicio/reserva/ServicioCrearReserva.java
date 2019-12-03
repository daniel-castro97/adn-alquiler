package com.ceiba.alquiler.dominio.servicio.reserva;

import java.text.ParseException;

import com.ceiba.alquiler.aplicacion.comando.ComandoMoto;
import com.ceiba.alquiler.dominio.entidades.CalcularPrecio;
import com.ceiba.alquiler.dominio.entidades.Reserva;
import com.ceiba.alquiler.dominio.entidades.ValidarFecha;
import com.ceiba.alquiler.dominio.excepcion.ExcepcionFecha;
import com.ceiba.alquiler.dominio.repositorio.RepositorioMoto;
import com.ceiba.alquiler.dominio.repositorio.RepositorioReserva;

public class ServicioCrearReserva {

	private RepositorioReserva repositorioReserva;
	
	private RepositorioMoto moto;
	
	private int precioTotal;
	
	private static final String DIA_NO_DISPONIBLE = "No se aceptan solicitudes los Domingos";

	public ServicioCrearReserva(RepositorioReserva repositorioReserva, RepositorioMoto moto) {
		
		this.repositorioReserva = repositorioReserva;
		this.moto=moto;
	}
	
	public void crear(Reserva reserva) throws ParseException {
		validarFechaSolicitud(reserva);
		validarFechaInicio(reserva);
		precioTotal = precioReserva(reserva);
		reserva.setValorTotal(precioTotal);
		this.repositorioReserva.crear(reserva);
		
	}
	
	public void validarFechaSolicitud(Reserva reserva){
		if(ValidarFecha.determinarDia(reserva.getFechaSolicitud()).equals("Domingo")){
			throw new ExcepcionFecha(DIA_NO_DISPONIBLE);
		}
	}
	
	public void validarFechaInicio(Reserva reserva) {
		if(ValidarFecha.determinarDia(reserva.getFechaSolicitud()).equals("Domingo")) {
			reserva.setFechaInicio(ValidarFecha.siguienteHabil(reserva.getFechaInicio(), 1));
		}
		else if(ValidarFecha.determinarDia(reserva.getFechaSolicitud()).equals("Sabado")) {
			reserva.setFechaInicio(ValidarFecha.siguienteHabil(reserva.getFechaInicio(), 2));
		}
	}
	
	public int precioReserva(Reserva reserva) throws ParseException {
		ComandoMoto aux = moto.buscar(reserva.getMoto().getPlaca());
		int precioAux = aux.getPrecioAlquiler();
		int cilindradaAux = aux.getCilindrada();
		return CalcularPrecio.calcularPrecioReserva(
				reserva.getFechaInicio(), 
				reserva.getFechaFin(),
				precioAux,
				cilindradaAux);
	}
	
}
