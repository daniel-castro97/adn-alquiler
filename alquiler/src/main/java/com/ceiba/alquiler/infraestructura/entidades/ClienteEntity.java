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
	private Date fechaNacimiento;
}

