package br.com.treinamento.richfaces.backingbean;

import java.util.ArrayList;

import br.com.treinamento.richfaces.controller.FilmeController;
import br.com.treinamento.richfaces.model.Filme;
import br.com.treinamento.richfaces.util.JSFUtil;
import br.com.treinamento.richfaces.util.Mensagem;
import br.com.treinamento.richfaces.util.Valida;

public class FilmeBacking {

	private String nome;
	private String genero;
	private String diretor;
	private ArrayList<Filme> listaFilme;
	private Filme filmeSelecionado;

	public Filme getFilmeSelecionado() {
		return filmeSelecionado;
	}

	public void setFilmeSelecionado(Filme filmeSelecionado) {
		this.filmeSelecionado = filmeSelecionado;
	}

	public ArrayList<Filme> getListaFilme() {
		return listaFilme;
	}

	public void setListaFilme(ArrayList<Filme> listaFilme) {
		this.listaFilme = listaFilme;
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

	/*
	 * método responsavel por abrir a tela cadastrarFime.jsp
	 */
	public String cadastrarFilme() {
		return "";
	}

	/*
	 * método responsavel por abrir a tela consultarFilme.jsp
	 */
	public String consultarFilme() {
		return "";
	}

	public void salvar() {
		if (validar()) {
			if (validar()) {
				if (new FilmeController().inserir(new Filme(nome, genero, diretor))) {
					JSFUtil.addInfoMessage(Mensagem.filmeGravado);
					cancelar();
				}
			}
		}

	}

	public void cancelar() {
		nome = "";
		genero = "";
		diretor = "";
	}

	public boolean validar() {
		if (Valida.verificaStringVazio(nome)) {
			JSFUtil.addErrorMessage(Mensagem.informeNome);
			return false;
		}
		if (Valida.verificaStringVazio(genero)) {
			JSFUtil.addErrorMessage(Mensagem.informeGenero);
			return false;
		}

		if (Valida.verificaStringVazio(diretor)) {
			JSFUtil.addErrorMessage(Mensagem.informeDiretor);
			return false;
		}
		if (Valida.verificaNumeros(diretor)) {
			JSFUtil.addErrorMessage(Mensagem.informeDiretor);
			return false;
		}
		return true;
	}

	public String pesquisar() {
		if (Valida.verificaStringVazio(nome)) {
			listaFilme = new FilmeController().buscarTodos();
		} else {
			listaFilme = new FilmeController().buscarNome(nome);
		}

		return "";
	}

	public String alterar() {
		//System.out.println(filmeSelecionado.getNome());
		nome = filmeSelecionado.getNome();
		genero = filmeSelecionado.getGenero();
		diretor = filmeSelecionado.getDiretor();
		return "alterar";
	}
	
	public String salvarAlterar() {
		if (Valida.verificaStringVazio(genero)) {
			JSFUtil.addInfoMessage(Mensagem.erroAlterarFilme);
		}else {
			filmeSelecionado.setGenero(genero);
			if (new FilmeController().alterar(filmeSelecionado)) {
				JSFUtil.addInfoMessage(Mensagem.filmeAlterado);
			}
		}
		
		return "";
	}

	public String excluir() {
		if (new FilmeController().excluir(filmeSelecionado)) {
			pesquisar();
			JSFUtil.addInfoMessage(Mensagem.filmeExcluido);
		} else {
			JSFUtil.addErrorMessage(Mensagem.erroExcluirFilme);
		}
		return "";
	}

}
