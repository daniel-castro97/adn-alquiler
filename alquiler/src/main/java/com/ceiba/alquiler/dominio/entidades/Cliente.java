package com.ceiba.alquiler.dominio.entidades;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 * Clase Cliente
 * @author daniel.castro
 *
 */
@Getter
@Setter
@NoArgsConstructor
public class Cliente {
	
	private static final String LA_CEDULA_ES_OBLIGATORIA ="La cedula es un campo obligatorio";
	private static final String EL_NOMBRE_ES_OBLIGATORIO = "El nombre es un campo obligatorio";
	private static final String LA_FECHA_ES_OBLIGATORIA = "La fecha de nacimiento es un campo obligatorio";
	private static final String EL_CORREO_ES_UN_CAMPO_OBLIGATORIO = "El correo electronico es un campo obligatorio";
	private static final String EL_PASE_ES_OBLIGATORIO = "La categoria del pase es un campo obligatorio";
	private static final int TAMANIO_PASE = 2;
	private static final String EL_PASE_DEBE_TENER = "El pase debe tener minimo dos caracteres";
	
	private Long cedula;
	private String nombre;
	private Date fechaNacimineto;
	private Long telefono;
	private String correo;
	private String categoriaPase;
	
	public Cliente(Long cedula, String nombre, Date fechaNacimineto, Long telefono, String correo,
			String categoriaPase) {
		ValidadorCliente.validarPase(categoriaPase, TAMANIO_PASE, EL_PASE_DEBE_TENER);
		ValidadorCliente.validarObligatorio(nombre, EL_NOMBRE_ES_OBLIGATORIO);
		ValidadorCliente.validarObligatorio(correo, EL_CORREO_ES_UN_CAMPO_OBLIGATORIO);
		ValidadorCliente.validarObligatorio(categoriaPase, EL_PASE_ES_OBLIGATORIO);
		ValidadorCliente.validarObligatorio(cedula, LA_CEDULA_ES_OBLIGATORIA);
		ValidadorCliente.validarObligatorio(fechaNacimineto, LA_FECHA_ES_OBLIGATORIA);
		this.cedula = cedula;
		this.nombre = nombre;
		this.fechaNacimineto = fechaNacimineto;
		this.telefono = telefono;
		this.correo = correo;
		this.categoriaPase = categoriaPase;
	}

}
