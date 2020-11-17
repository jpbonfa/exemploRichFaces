package br.com.treinamento.richfaces.util;

import br.com.treinamento.richfaces.controller.FilmeController;
import br.com.treinamento.richfaces.model.Filme;

public class TestaBuscarFilmes {

	public static void main(String[] args) {

		for (Filme filme : new FilmeController().buscarTodos()) {
			System.out.println("Nome do filme: " + filme.getNome());
			System.out.println("genero do filme: " + filme.getGenero());
			System.out.println("diretor do filme: " + filme.getDiretor());
			System.out.println("");
		}

	}
}
