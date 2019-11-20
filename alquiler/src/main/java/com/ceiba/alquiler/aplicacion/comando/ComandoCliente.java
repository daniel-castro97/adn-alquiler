package com.ceiba.alquiler.aplicacion.comando;

import java.util.Date;

public class ComandoCliente {
	
	private Long cedula;
	private String nombre;
	private Date fechaNacimineto;
	private Long telefono;
	private String correo;
	private String categoriaPase;
	
	public ComandoCliente(Long cedula, String nombre, Date fechaNacimineto, Long telefono, String correo,
			String categoriaPase) {
		
		this.cedula = cedula;
		this.nombre = nombre;
		this.fechaNacimineto = fechaNacimineto;
		this.telefono = telefono;
		this.correo = correo;
		this.categoriaPase = categoriaPase;
	}
	
	
	public ComandoCliente() {
	}


	public Long getCedula() {
		return cedula;
	}

	public void setCedula(Long cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaNacimineto() {
		return fechaNacimineto;
	}

	public void setFechaNacimineto(Date fechaNacimineto) {
		this.fechaNacimineto = fechaNacimineto;
	}

	public Long getTelefono() {
		return telefono;
	}

	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getCategoriaPase() {
		return categoriaPase;
	}

	public void setCategoriaPase(String categoriaPase) {
		this.categoriaPase = categoriaPase;
	}
}
