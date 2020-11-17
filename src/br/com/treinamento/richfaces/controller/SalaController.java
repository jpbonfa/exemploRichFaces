package br.com.treinamento.richfaces.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;

import br.com.treinamento.richfaces.dao.SalaDAO;
import br.com.treinamento.richfaces.dao.SalaDAO;
import br.com.treinamento.richfaces.dao.SalaDAO;
import br.com.treinamento.richfaces.model.Sala;
import br.com.treinamento.richfaces.model.Sala;
import br.com.treinamento.richfaces.model.Sala;
import br.com.treinamento.richfaces.util.ConnectionFactory;

public class SalaController {

	private Connection conexao = ConnectionFactory.getConnection();

	public boolean inserir(Sala sala) {

		SalaDAO dao = new SalaDAO(conexao);
		try {
			dao.inserir(sala);
			conexao.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public ArrayList<Sala> buscarTipo(String tipo) {
		SalaDAO dao = new SalaDAO(conexao);
		ArrayList<Sala> retorno = new ArrayList<Sala>();
		try {
			retorno = dao.buscarTipo(tipo);
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return retorno;
	}

	public boolean excluir(Sala sala) {
		SalaDAO dao = new SalaDAO(conexao);
		try {
			dao.excluir(sala);
			conexao.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public ArrayList<Sala> buscarTodos() {
		ArrayList<Sala> listaSalas = new ArrayList<Sala>();
		SalaDAO dao = new SalaDAO(conexao);
		try {
			listaSalas = dao.buscarTodos();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return listaSalas;
	}

	public boolean alterar(Sala sala) {
		SalaDAO dao = new SalaDAO(conexao);
		try {
			dao.alterar(sala);
			conexao.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
