package com.ceiba.alquiler.dominio.entidades;

import java.util.Date;
/**
 * Clase Cliente
 * @author daniel.castro
 *
 */
public class Cliente {
	/*
	 * Atributos
	 */
	private Long cedula;
	private String nombre;
	private Date fechaNacimineto;
	private Long telefono;
	private String correo;
	private String categoriaPase;
	/**
	 * Constructor de clase cliente
	 * @param cedula
	 * @param nombre
	 * @param fechaNacimineto
	 * @param telefono
	 * @param correo
	 * @param categoriaPase
	 */
	public Cliente(Long cedula, String nombre, Date fechaNacimineto, Long telefono, String correo,
			String categoriaPase) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.fechaNacimineto = fechaNacimineto;
		this.telefono = telefono;
		this.correo = correo;
		this.categoriaPase = categoriaPase;
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
