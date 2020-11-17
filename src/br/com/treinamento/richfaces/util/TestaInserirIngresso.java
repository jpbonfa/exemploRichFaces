package br.com.treinamento.richfaces.util;

import br.com.treinamento.richfaces.controller.IngressoController;
import br.com.treinamento.richfaces.model.Ingresso;

public class TestaInserirIngresso {

	public static void main(String[] args) {

		Ingresso ingresso = new Ingresso("Bradesco", 20);
		IngressoController controller = new IngressoController();
		controller.inserir(ingresso);

	}

}
