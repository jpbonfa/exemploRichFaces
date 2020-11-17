package br.com.treinamento.richfaces.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import br.com.treinamento.richfaces.model.Ingresso;
import br.com.treinamento.richfaces.model.Ingresso;

public class IngressoDAO {

	private Connection bd;

	public IngressoDAO(Connection bd) {
		this.bd = bd;
	}

	public void inserir(Ingresso ingresso) throws SQLException {
		String sql = "INSERT INTO ingresso (tipo,valor) VALUES (?,?)";
		PreparedStatement comando = (PreparedStatement) bd.prepareStatement(sql);
		comando.setString(1, ingresso.getTipo());
		comando.setDouble(2, ingresso.getValor());
		comando.execute();
	}

	public void alterar(Ingresso ingresso) throws SQLException {
		String sql = "UPDATE ingresso SET valor=? WHERE tipo=?;";
		PreparedStatement comando = (PreparedStatement) bd.prepareStatement(sql);
		comando.setDouble(1, ingresso.getValor());
		comando.setString(2, ingresso.getTipo());
		comando.execute();
	}

	public ArrayList<Ingresso> buscarTipo(String tipo) throws SQLException {
		String sql = "SELECT * FROM ingresso WHERE tipo LIKE ?";
		PreparedStatement comando = (PreparedStatement) bd.prepareStatement(sql);
		comando.setString(1, tipo + "%");
		ResultSet cursor = comando.executeQuery();
		ArrayList<Ingresso> listaIngresso = new ArrayList<Ingresso>();

		while (cursor.next()) {
			Ingresso ingresso = new Ingresso();
			ingresso.setTipo(cursor.getString("tipo"));
			ingresso.setValor(cursor.getDouble("valor"));
			listaIngresso.add(ingresso);
		}
		return listaIngresso;
	}

	public void excluir(Ingresso ingresso) throws SQLException {
		String sql = "DELETE FROM ingresso WHERE tipo = ?";
		PreparedStatement comando = (PreparedStatement) bd.prepareStatement(sql);
		comando.setString(1, ingresso.getTipo());
		comando.execute();
	}

	public ArrayList<Ingresso> buscarTodos() throws SQLException {
		String sql = "SELECT * FROM ingresso ORDER BY tipo";
		PreparedStatement comando = (PreparedStatement) bd.prepareStatement(sql);
		ResultSet cursor = comando.executeQuery();
		ArrayList<Ingresso> listaIngresso = new ArrayList<Ingresso>();

		while (cursor.next()) {
			Ingresso ingresso = new Ingresso();
			ingresso.setTipo(cursor.getString("tipo"));
			ingresso.setValor(cursor.getDouble("valor"));
			listaIngresso.add(ingresso);
		}

		return listaIngresso;
	}

}
