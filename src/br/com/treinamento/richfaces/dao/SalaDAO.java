package br.com.treinamento.richfaces.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import br.com.treinamento.richfaces.model.Sala;
import br.com.treinamento.richfaces.model.Sala;
import br.com.treinamento.richfaces.model.Sala;
import br.com.treinamento.richfaces.model.Sala;
import br.com.treinamento.richfaces.model.Sala;

public class SalaDAO {

	private Connection bd;

	public SalaDAO(Connection bd) {
		this.bd = bd;
	}

	public void inserir(Sala sala) throws SQLException {
		String sql = "INSERT INTO sala (tipo,lugares) VALUES (?,?)";
		PreparedStatement comando = (PreparedStatement) bd.prepareStatement(sql);
		comando.setString(1, sala.getTipo());
		comando.setInt(2, sala.getLugares());
		comando.execute();
	}

	public void alterar(Sala sala) throws SQLException {
		String sql = "UPDATE sala SET lugares=? WHERE tipo=?;";
		PreparedStatement comando = (PreparedStatement) bd.prepareStatement(sql);
		comando.setInt(1, sala.getLugares());
		comando.setString(2, sala.getTipo());
		comando.execute();
	}

	public ArrayList<Sala> buscarTipo(String tipo) throws SQLException {
		String sql = "SELECT * FROM sala WHERE tipo LIKE ?";
		PreparedStatement comando = (PreparedStatement) bd.prepareStatement(sql);
		comando.setString(1, tipo + "%");
		ResultSet cursor = comando.executeQuery();
		ArrayList<Sala> listaSala = new ArrayList<Sala>();

		while (cursor.next()) {
			Sala sala = new Sala();
			sala.setTipo(cursor.getString("tipo"));
			sala.setLugares(cursor.getInt("lugares"));
			listaSala.add(sala);
		}
		return listaSala;
	}

	public void excluir(Sala sala) throws SQLException {
		String sql = "DELETE FROM sala WHERE tipo = ?";
		PreparedStatement comando = (PreparedStatement) bd.prepareStatement(sql);
		comando.setString(1, sala.getTipo());
		comando.execute();
	}

	public ArrayList<Sala> buscarTodos() throws SQLException {
		String sql = "SELECT * FROM sala ORDER BY tipo";
		PreparedStatement comando = (PreparedStatement) bd.prepareStatement(sql);
		ResultSet cursor = comando.executeQuery();
		ArrayList<Sala> listaSala = new ArrayList<Sala>();

		while (cursor.next()) {
			Sala sala = new Sala();
			sala.setTipo(cursor.getString("tipo"));
			sala.setLugares(cursor.getInt("lugares"));
			listaSala.add(sala);
		}

		return listaSala;
	}
}
