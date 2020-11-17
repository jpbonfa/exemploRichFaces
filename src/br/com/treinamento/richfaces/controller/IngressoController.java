package br.com.treinamento.richfaces.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;

import br.com.treinamento.richfaces.dao.IngressoDAO;
import br.com.treinamento.richfaces.dao.IngressoDAO;
import br.com.treinamento.richfaces.model.Ingresso;
import br.com.treinamento.richfaces.model.Ingresso;
import br.com.treinamento.richfaces.util.ConnectionFactory;

public class IngressoController {

	private Connection conexao = ConnectionFactory.getConnection();

	public boolean inserir(Ingresso ingresso) {

		IngressoDAO dao = new IngressoDAO(conexao);
		try {
			dao.inserir(ingresso);
			conexao.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public ArrayList<Ingresso> buscarTipo(String tipo) {
		IngressoDAO dao = new IngressoDAO(conexao);
		ArrayList<Ingresso> retorno = new ArrayList<Ingresso>();
		try {
			retorno = dao.buscarTipo(tipo);
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return retorno;
	}

	public boolean excluir(Ingresso ingresso) {
		IngressoDAO dao = new IngressoDAO(conexao);
		try {
			dao.excluir(ingresso);
			conexao.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public ArrayList<Ingresso> buscarTodos() {
		ArrayList<Ingresso> listaIngressos = new ArrayList<Ingresso>();
		IngressoDAO dao = new IngressoDAO(conexao);
		try {
			listaIngressos = dao.buscarTodos();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return listaIngressos;
	}

	public boolean alterar(Ingresso ingresso) {
		IngressoDAO dao = new IngressoDAO(conexao);
		try {
			dao.alterar(ingresso);
			conexao.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
