package br.com.treinamento.richfaces.model;

import java.text.NumberFormat;

public class Ingresso {

	private String tipo;
	private double valor;

	public Ingresso() {
	}

	public Ingresso(String tipo, double valor) {
		super();
		this.tipo = tipo;
		this.valor = valor;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getValor() {
		return valor;
	}
	
	public String getValorFormatado() {
		return NumberFormat.getCurrencyInstance().format(valor);
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

}
