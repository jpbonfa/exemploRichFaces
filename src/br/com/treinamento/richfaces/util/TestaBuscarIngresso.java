package br.com.treinamento.richfaces.util;

import br.com.treinamento.richfaces.controller.IngressoController;
import br.com.treinamento.richfaces.model.Ingresso;

public class TestaBuscarIngresso {

	public static void main(String[] args) {
		for (Ingresso ingresso : new IngressoController().buscarTodos()) {
			System.out.println("Nome do ingresso: " + ingresso.getTipo());
			System.out.println("genero do ingresso: " + ingresso.getValor());
			System.out.println("");
		}
	}

}
