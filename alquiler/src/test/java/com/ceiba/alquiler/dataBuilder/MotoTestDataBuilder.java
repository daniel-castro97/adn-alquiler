package com.ceiba.alquiler.dataBuilder;

import com.ceiba.alquiler.dominio.entidades.Moto;

public class MotoTestDataBuilder {


	
	private String placa;
	private String marca;
	private int anioModelo;
	private String referencia;
	private int cilindrada;
	private int precioAlquiler;
	
	public MotoTestDataBuilder (){
		this.placa= "rhd79e";
		this.marca = "pulsar";
		this.anioModelo =2018;
		this.referencia = "NS160";
		this.cilindrada = 160;
		this.precioAlquiler = 20000;
	}
	public MotoTestDataBuilder withPlaca (String placa) {
		this.placa = placa;
		return this;
	}
	public MotoTestDataBuilder withMarca (String marca) {
		this.marca = marca;
		return this;
	}
	public MotoTestDataBuilder withAnioModelo (int anioModelo) {
		this.anioModelo = anioModelo;
		return this;
	}
	public MotoTestDataBuilder withReferencia (String referencia) {
		this.referencia = referencia;
		return this;
	}
	public MotoTestDataBuilder withCilindrada (int cilindrada) {
		this.cilindrada = cilindrada;
		return this;
	}
	public MotoTestDataBuilder withPrecioAlquiler (int precioAlquiler) {
		this.precioAlquiler = precioAlquiler;
		return this;
	}
	
	public Moto build() {
		return new Moto(placa, marca, anioModelo, referencia, cilindrada, precioAlquiler);
	}

}
