package com.ceiba.alquiler.dominio.entidades;

public class Moto {

	private static final int TAMANIO_EXACTO_PLACA = 6;
	private static final String LA_CILINDRADA_DEBE_SER_OBLIGATORIA = "La cilindrada es un campo obligatorio";
	private static final String EL_PRECIO_ES_OBLIGATORIO = "El precio de alquiler es un campo obligatorio";
	private static final String LA_REFERENCIA_ES_OBLIGATORIA = "La referencia es un campo obligatorio";
	private static final String LA_PLACA_DEBE_TENER_MINIMO = "La placa debe tener minimo 6 caracteres";
	
	private String placa;
	private String marca;
	private int anioModelo;
	private String referencia;
	private int cilindrada;
	private int precioAlquiler;
	
	
	/**
	 * Metodo constructor
	 * @param placa
	 * @param marca
	 * @param anioModelo
	 * @param referencia
	 * @param cilindrada
	 * @param precioAlquiler
	 */
	public Moto(String placa, String marca, int anioModelo, String referencia, int cilindrada, 
			int precioAlquiler) {
		ValidadorMoto.validarPlaca(placa, TAMANIO_EXACTO_PLACA, LA_PLACA_DEBE_TENER_MINIMO);
		ValidadorMoto.validarObligatorio(referencia, LA_REFERENCIA_ES_OBLIGATORIA);
		ValidadorMoto.validarEntero(cilindrada, LA_CILINDRADA_DEBE_SER_OBLIGATORIA);
		ValidadorMoto.validarEntero(precioAlquiler, EL_PRECIO_ES_OBLIGATORIO);
		this.placa = placa;
		this.marca = marca;
		this.anioModelo = anioModelo;
		this.referencia = referencia;
		this.cilindrada = cilindrada;
		this.precioAlquiler = precioAlquiler;
	}



	public String getPlaca() {
		return placa;
	}



	public void setPlaca(String placa) {
		this.placa = placa;
	}



	public String getMarca() {
		return marca;
	}



	public void setMarca(String marca) {
		this.marca = marca;
	}



	public int getAnioModelo() {
		return anioModelo;
	}



	public void setAnioModelo(int anioModelo) {
		this.anioModelo = anioModelo;
	}



	public String getReferencia() {
		return referencia;
	}



	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}



	public int getCilindrada() {
		return cilindrada;
	}



	public void setCilindrada(int cilindrada) {
		this.cilindrada = cilindrada;
	}



	public int getPrecioAlquiler() {
		return precioAlquiler;
	}



	public void setPrecioAlquiler(int precioAlquiler) {
		this.precioAlquiler = precioAlquiler;
	}
	
	



}
