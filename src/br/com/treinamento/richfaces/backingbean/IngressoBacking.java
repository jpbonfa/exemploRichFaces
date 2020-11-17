package br.com.treinamento.richfaces.backingbean;

import java.util.ArrayList;

import br.com.treinamento.richfaces.controller.FilmeController;
import br.com.treinamento.richfaces.controller.IngressoController;
import br.com.treinamento.richfaces.controller.SalaController;
import br.com.treinamento.richfaces.controller.IngressoController;
import br.com.treinamento.richfaces.model.Ingresso;
import br.com.treinamento.richfaces.model.Ingresso;
import br.com.treinamento.richfaces.util.JSFUtil;
import br.com.treinamento.richfaces.util.Mensagem;
import br.com.treinamento.richfaces.util.Valida;

public class IngressoBacking {

	private String tipo;
	private String valor;
	private ArrayList<Ingresso> listaIngresso;
	private Ingresso ingressoSelecionado;

	public ArrayList<Ingresso> getListaIngresso() {
		return listaIngresso;
	}

	public void setListaIngresso(ArrayList<Ingresso> listaIngresso) {
		this.listaIngresso = listaIngresso;
	}

	public Ingresso getIngressoSelecionado() {
		return ingressoSelecionado;
	}

	public void setIngressoSelecionado(Ingresso ingressoSelecionado) {
		this.ingressoSelecionado = ingressoSelecionado;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	/*
	 * método responsavel por abrir a tela cadastrarFime.jsp
	 */
	public String cadastrarIngresso() {
		return "";
	}

	/*
	 * método responsavel por abrir a tela consultaIngresso.jsp
	 */
	public String consultarIngresso() {
		return "";
	}

	public void salvar() {
		if (validar()) {
			if (new IngressoController().inserir(new Ingresso(tipo, Double.parseDouble(valor)))) {
				JSFUtil.addInfoMessage(Mensagem.ingressoGravado);
				cancelar();
			} else {
				JSFUtil.addInfoMessage(Mensagem.erroGravarIngresso);
			}
		}
	}

	public void cancelar() {
		tipo = "";
		valor = "0";
	}

	public boolean validar() {
		if (Valida.verificaStringVazio(tipo)) {
			JSFUtil.addErrorMessage(Mensagem.informeTipo);
			return false;
		}
		if (Valida.verificaStringZero(valor)) {
			JSFUtil.addErrorMessage(Mensagem.informeValor);
			return false;
		}
		return true;
	}

	public String pesquisar() {
		if (Valida.verificaStringVazio(tipo)) {
			listaIngresso = new IngressoController().buscarTodos();
		} else {
			listaIngresso = new IngressoController().buscarTipo(tipo);
		}

		return "";
	}

	public String alterar() {
		// System.out.println(ingressoSelecionado.getTipo());
		tipo = ingressoSelecionado.getTipo();
		valor = ingressoSelecionado.getValorFormatado();
		return "alterar";
	}

	public String excluir() {
		if (new IngressoController().excluir(ingressoSelecionado)) {
			pesquisar();
			JSFUtil.addInfoMessage(Mensagem.ingressoExcluido);
		} else {
			JSFUtil.addErrorMessage(Mensagem.erroExcluirIngresso);
		}
		return "";
	}

	public String salvarAlterar() {
		if (Valida.verificaStringVazio(valor)) {
			JSFUtil.addInfoMessage(Mensagem.erroAlterarIngresso);
		} else {
			ingressoSelecionado.setValor(Double.parseDouble(valor));
			if (new IngressoController().alterar(ingressoSelecionado)) {
				JSFUtil.addInfoMessage(Mensagem.ingressoAlterado);
			}
		}

		return "";
	}

}