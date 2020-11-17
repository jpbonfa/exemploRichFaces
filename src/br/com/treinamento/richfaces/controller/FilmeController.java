package br.com.treinamento.richfaces.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;

import br.com.treinamento.richfaces.dao.FilmeDAO;
import br.com.treinamento.richfaces.model.Filme;
import br.com.treinamento.richfaces.util.ConnectionFactory;

public class FilmeController {

	private Connection conexao = ConnectionFactory.getConnection();

	public boolean inserir(Filme filme) {

		FilmeDAO dao = new FilmeDAO(conexao);
		try {
			dao.inserir(filme);
			conexao.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean alterar(Filme filme) {
		FilmeDAO dao = new FilmeDAO(conexao);
		try {
			dao.alterar(filme);
			conexao.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public ArrayList<Filme> buscarNome(String nome) {
		FilmeDAO dao = new FilmeDAO(conexao);
		ArrayList<Filme> retorno = new ArrayList<Filme>();
		try {
			retorno = dao.buscarNome(nome);
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return retorno;
	}

	public boolean excluir(Filme filme) {
		FilmeDAO dao = new FilmeDAO(conexao);
		try {
			dao.excluir(filme);
			conexao.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public ArrayList<Filme> buscarTodos() {
		ArrayList<Filme> listaFilmes = new ArrayList<Filme>();
		FilmeDAO dao = new FilmeDAO(conexao);
		try {
			listaFilmes = dao.buscarTodos();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return listaFilmes;
	}

}
