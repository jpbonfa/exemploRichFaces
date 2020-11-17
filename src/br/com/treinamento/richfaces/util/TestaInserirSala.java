package br.com.treinamento.richfaces.util;

import br.com.treinamento.richfaces.controller.SalaController;
import br.com.treinamento.richfaces.model.Sala;

public class TestaInserirSala {

	public static void main(String[] args) {
		Sala sala = new Sala("IMAX", 2);
		SalaController controller = new SalaController();
		controller.inserir(sala);
	}

}
