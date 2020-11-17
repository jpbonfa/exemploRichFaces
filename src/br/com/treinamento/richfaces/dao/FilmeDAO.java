package br.com.treinamento.richfaces.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import br.com.treinamento.richfaces.model.Filme;

public class FilmeDAO {

	private Connection bd;

	public FilmeDAO(Connection bd) {
		this.bd = bd;
	}

	public void inserir(Filme filme) throws SQLException {
		String sql = "INSERT INTO filme (nome,genero,diretor) VALUES (?,?,?)";
		PreparedStatement comando = (PreparedStatement) bd.prepareStatement(sql);
		comando.setString(1, filme.getNome());
		comando.setString(2, filme.getGenero());
		comando.setString(3, filme.getDiretor());
		comando.execute();
	}
	
	public void alterar(Filme filme) throws SQLException {
		String sql = "UPDATE filme SET genero=? WHERE nome=?;";
		PreparedStatement comando = (PreparedStatement) bd.prepareStatement(sql);
		comando.setString(1, filme.getGenero());
		comando.setString(2, filme.getNome());
		comando.execute();
	}


	public ArrayList<Filme> buscarNome(String nome) throws SQLException {
		String sql = "SELECT * FROM filme WHERE nome LIKE ?";
		PreparedStatement comando = (PreparedStatement) bd.prepareStatement(sql);
		comando.setString(1, nome + "%");
		ResultSet cursor = comando.executeQuery();
		ArrayList<Filme> listaFilme = new ArrayList<Filme>();

		while (cursor.next()) {
			Filme filme = new Filme();
			filme.setNome(cursor.getString("nome"));
			filme.setGenero(cursor.getString("genero"));
			filme.setDiretor(cursor.getString("diretor"));
			listaFilme.add(filme);
		}
		return listaFilme;
	}

	public void excluir(Filme filme) throws SQLException {
		String sql = "DELETE FROM filme WHERE nome = ?";
		PreparedStatement comando = (PreparedStatement) bd.prepareStatement(sql);
		comando.setString(1, filme.getNome());
		comando.execute();
	}

	public ArrayList<Filme> buscarTodos() throws SQLException {
		String sql = "SELECT * FROM filme ORDER BY nome";
		PreparedStatement comando = (PreparedStatement) bd.prepareStatement(sql);
		ResultSet cursor = comando.executeQuery();
		ArrayList<Filme> listaFilme = new ArrayList<Filme>();

		while (cursor.next()) {
			Filme filme = new Filme();
			filme.setNome(cursor.getString("nome"));
			filme.setGenero(cursor.getString("genero"));
			filme.setDiretor(cursor.getString("diretor"));
			listaFilme.add(filme);
		}

		return listaFilme;
	}

}
