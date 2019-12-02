package com.ceiba.alquiler.infraestructura.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
/**
 * Entidad cliente para el mapeo de talas en la base de datos
 * @author daniel.castro
 *
 */
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class ClienteEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cedula")
	private Long cedula;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="fecha_nacimiento")
	@Temporal(TemporalType.DATE)
	private Date fechaNacimineto;
	
	public Date getFechaNacimineto() {
		return fechaNacimineto;
	}

	public void setFechaNacimineto(Date fechaNacimineto) {
		this.fechaNacimineto = fechaNacimineto;
	}

	@Column(name="telefono")
	private Long telefono;
	
	@Column(name="correo")
	private String correo;
	
	@Column(name="categoria_pase")
	private String categoriaPase;

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}

