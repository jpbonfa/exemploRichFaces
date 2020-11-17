package br.com.treinamento.richfaces.util;

import br.com.treinamento.richfaces.controller.FilmeController;
import br.com.treinamento.richfaces.model.Filme;

public class TestaInserirFilme {

	public static void main(String[] args) {

		Filme filme = new Filme(" go Diego, go", "Infantil", "Tarantino");
		FilmeController controller = new FilmeController();
		controller.inserir(filme);

	}

}
