package br.com.treinamento.richfaces.backingbean;

import java.util.ArrayList;

import br.com.treinamento.richfaces.controller.IngressoController;
import br.com.treinamento.richfaces.controller.SalaController;
import br.com.treinamento.richfaces.model.Sala;
import br.com.treinamento.richfaces.util.JSFUtil;
import br.com.treinamento.richfaces.util.Mensagem;
import br.com.treinamento.richfaces.util.Valida;

public class SalaBacking {

	private String tipo;
	private String lugares = "0";
	private ArrayList<Sala> listaSala;
	private Sala SalaSelecionada;

	public ArrayList<Sala> getListaSala() {
		return listaSala;
	}

	public void setListaSala(ArrayList<Sala> listaSala) {
		this.listaSala = listaSala;
	}

	public Sala getSalaSelecionada() {
		return SalaSelecionada;
	}

	public void setSalaSelecionada(Sala salaSelecionada) {
		SalaSelecionada = salaSelecionada;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getLugares() {
		return lugares;
	}

	public void setLugares(String lugares) {
		this.lugares = lugares;
	}

	/*
	 * método responsavel por abrir a tela cadastrarSala.jsp
	 */
	public String cadastrarSala() {
		return "";
	}

	/*
	 * método responsavel por abrir a tela consultaSala.jsp
	 */
	public String consultarSala() {
		return "";
	}

	public void salvar() {
		if (validar()) {
			if (new SalaController().inserir(new Sala(tipo, Integer.parseInt(lugares)))) {
				JSFUtil.addInfoMessage(Mensagem.salaGravada);
				cancelar();
			} else {
				JSFUtil.addInfoMessage(Mensagem.erroGravarSala);
			}

		}

	}

	public void cancelar() {
		tipo = "";
		lugares = "0";
	}

	public boolean validar() {
		if (Valida.verificaStringVazio(tipo)) {
			JSFUtil.addErrorMessage(Mensagem.informeTipo);
			return false;
		}
		if (Valida.verificaStringZero(lugares)) {
			JSFUtil.addErrorMessage(Mensagem.informeLugares);
			return false;
		}
		return true;
	}

	public String pesquisar() {
		if (Valida.verificaStringVazio(tipo)) {
			listaSala = new SalaController().buscarTodos();
		} else {
			listaSala = new SalaController().buscarTipo(tipo);

		}

		return "";
	}

	public String alterar() {

		tipo = SalaSelecionada.getTipo();
		lugares = SalaSelecionada.getLugares() + "";
		return "alterar";
	}

	public String excluir() {
		if (new SalaController().excluir(SalaSelecionada)) {
			pesquisar();
			JSFUtil.addInfoMessage(Mensagem.salaExcluida);
		} else {
			JSFUtil.addErrorMessage(Mensagem.erroExcluirSala);
		}
		return "";
	}

	public String salvarAlterar() {
		if (Valida.verificaStringVazio(lugares)) {
			JSFUtil.addInfoMessage(Mensagem.erroAlterarSala);
		} else {
			SalaSelecionada.setLugares(Integer.parseInt(lugares));
			if (new SalaController().alterar(SalaSelecionada)) {
				JSFUtil.addInfoMessage(Mensagem.salaAlterada);
			}
		}

		return "";
	}
}
