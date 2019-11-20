package com.ceiba.alquiler.aplicacion.comando;

/**
 * Clase comando
 * @author daniel.castro
 *
 */
public class ComandoMoto {

	/*
	 * Atributos
	 */
	private String placa;
	private String marca;
	private int modelo;
	private String referencia;
	private int cilindrada;
	private int precioAlquiler;
	
	/**
	 * Consturctor de clase
	 * @param placa
	 * @param marca
	 * @param modelo
	 * @param referencia
	 * @param cilindrada
	 * @param precioAlquiler
	 */
	public ComandoMoto(String placa, String marca, int modelo, String referencia, int cilindrada, int precioAlquiler) {
		super();
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
		this.referencia = referencia;
		this.cilindrada = cilindrada;
		this.precioAlquiler = precioAlquiler;
	}
	
	
	/**
	 * Constructor vacio
	 */
	public ComandoMoto() {
		super();
		// TODO Auto-generated constructor stub
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

	public int getModelo() {
		return modelo;
	}

	public void setModelo(int modelo) {
		this.modelo = modelo;
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
