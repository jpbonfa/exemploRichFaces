package br.com.treinamento.richfaces.util;

import br.com.treinamento.richfaces.controller.SalaController;
import br.com.treinamento.richfaces.model.Sala;

public class TestaBuscarSala {
	
	public static void main(String[] args) {

		for (Sala sala : new SalaController().buscarTodos()) {
			System.out.println("Nome do sala: " + sala.getTipo());
			System.out.println("genero do sala: " + sala.getLugares());
			System.out.println("");
		}

	}
}
