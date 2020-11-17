package br.com.treinamento.richfaces.model;

public class Filme {

	private String nome;
	private String genero;
	private String diretor;

	public Filme() {

	}

	public Filme(String nome, String genero, String diretor) {

		this.nome = nome;
		this.genero = genero;
		this.diretor = diretor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getDiretor() {
		return diretor;
	}

	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}

}
