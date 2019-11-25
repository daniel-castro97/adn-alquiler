package com.ceiba.alquiler.dataBuilder;

import java.util.Date;

import com.ceiba.alquiler.dominio.entidades.Cliente;

public class ClienteTestDataBuilder {
	
	private Long cedula;
	private String nombre;
	private Date fechaNacimineto;
	private Long telefono;
	private String correo;
	private String categoriaPase;

	public ClienteTestDataBuilder() {
		this.cedula=(long) 1111111111;
		this.nombre = "Juan Perez";
		this.fechaNacimineto = new Date();
		this.telefono = (long) 350255897;
		this.correo = "jperez@example.com";
		this.categoriaPase = "A1";
	}
	
	public ClienteTestDataBuilder withCedula(Long cedula) {
		this.cedula = cedula;
		return this;
	}
	
	public ClienteTestDataBuilder withNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}
	
	public ClienteTestDataBuilder withFechaNacimiento (Date fecha) {
		this.fechaNacimineto = fecha;
		return this;
	}
	
	public ClienteTestDataBuilder withTelefono (Long telefono) {
		this.telefono = telefono;
		return this;
	}
	
	public ClienteTestDataBuilder withCorreo(String correo) {
		this.correo = correo;
		return this;
	}
	
	public ClienteTestDataBuilder withPase(String pase) {
		this.categoriaPase=pase;
		return this;
	}
	
	public Cliente build() {
		return new Cliente(cedula, nombre, fechaNacimineto, telefono, correo, categoriaPase);
	}
}
