package br.com.treinamento.richfaces.model;

public class Sala {

	private String tipo;
	private int lugares;

	public Sala() {
		// TODO Auto-generated constructor stub
	}

	public Sala(String tipo, int lugares) {
		super();
		this.tipo = tipo;
		this.lugares = lugares;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getLugares() {
		return lugares;
	}

	public void setLugares(int lugares) {
		this.lugares = lugares;
	}

}
