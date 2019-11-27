package com.ceiba.alquiler.dataBuilder;

import java.util.Date;

import com.ceiba.alquiler.aplicacion.comando.ComandoCliente;

public class ComandoClienteTestDatabuilder {

	
	private Long cedula;
	private String nombre;
	private Date fechaNacimineto;
	private Long telefono;
	private String correo;
	private String categoriaPase;

	public ComandoClienteTestDatabuilder() {
		this.cedula=(long) 1111111111;
		this.nombre = "Juan Perez";
		this.fechaNacimineto = new Date();
		this.telefono = (long) 350255897;
		this.correo = "jperez@example.com";
		this.categoriaPase = "A1";
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

	public ComandoCliente build() {
		return new ComandoCliente(cedula, nombre, fechaNacimineto, telefono, correo, categoriaPase);
	}


}
