package com.ceiba.alquiler.dataBuilder;

import com.ceiba.alquiler.aplicacion.comando.ComandoMoto;

public class ComandoMotoTestDatabuilder {
	private String placa;
	private String marca;
	private int anioModelo;
	private String referencia;
	private int cilindrada;
	private int precioAlquiler;
	
	public ComandoMotoTestDatabuilder (){
		this.placa= "rhd79e";
		this.marca = "pulsar";
		this.anioModelo =2018;
		this.referencia = "NS160";
		this.cilindrada = 160;
		this.precioAlquiler = 20000;
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
	
	public ComandoMoto build() {
		return new ComandoMoto(placa, marca, anioModelo, referencia, cilindrada, precioAlquiler);
	}
}
