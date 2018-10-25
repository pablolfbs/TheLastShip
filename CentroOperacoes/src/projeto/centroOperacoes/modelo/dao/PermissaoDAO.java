package projeto.centroOperacoes.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import projeto.centroOperacoes.modelo.Permissao;
import projeto.centroOperacoes.modelo.Usuario;

public class PermissaoDAO {
	Connection connection = ConnectionFactory.getConnection();

	public void inserir(Permissao permissao, Usuario usuario) {
		String sql = "INSERT INTO permissao (permissao_id, permissao_nome, permissao_status, usuario_usuario_id) VALUES (?, ?, ?, ?);";

		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, permissao.getPermissao_id());
			ps.setString(2, permissao.getPermissao_nome());
			ps.setInt(3, permissao.getPermissao_status());
			ps.setInt(4, usuario.getUsuario_id());
			ps.execute();
			// JOptionPane.showMessageDialog(null, "INSERIDO COM SUCESSO!");
			ps.close();
		} catch (SQLException e) {
			// JOptionPane.showMessageDialog(null, "FALHOU!");
			e.printStackTrace();
		}
	}

	public void atualizar(Permissao permissao) {
		String sql = "UPDATE permissao SET permissao_nome = ?, permissao_status = ? WHERE permissao_id = ?;";

		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, permissao.getPermissao_nome());
			ps.setInt(2, permissao.getPermissao_status());
			ps.setInt(3, permissao.getPermissao_id());
			ps.execute();
			// JOptionPane.showMessageDialog(null, "ATUALIZADO COM SUCESSO!");
			ps.close();
		} catch (SQLException e) {
			// JOptionPane.showMessageDialog(null, "FALHOU!");
			e.printStackTrace();
		}
	}

	public void excluir(int id) {
		String sql = "DELETE FROM permissao WHERE permissao_id = ?;";

		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
			// JOptionPane.showMessageDialog(null, "DELETADO COM SUCESSO!");
			ps.close();
		} catch (SQLException e) {
			// JOptionPane.showMessageDialog(null, "FALHOU!");
			e.printStackTrace();
		}
	}

	public List<Permissao> listar() {
		String sql = "SELECT * FROM permissao;";

		Statement stmt;
		ResultSet rs;
		List<Permissao> permissoes = new ArrayList<Permissao>();
		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Permissao permissao = new Permissao();
				permissao.setPermissao_id(rs.getInt("permissao_id"));
				permissao.setPermissao_nome(rs.getString("permissao_nome"));
				permissao.setPermissao_status(rs.getInt("permissao_status"));
				permissoes.add(permissao);
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return permissoes;
	}
	
	public List<Permissao> buscar(Integer permissao_id) {
		String sql = "SELECT * FROM permissao WHERE permissao_id = " + permissao_id;

		Statement stmt;
		ResultSet rs;
		List<Permissao> permissoes = new ArrayList<Permissao>();
		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Permissao permissao = new Permissao();
				permissao.setPermissao_id(rs.getInt("permissao_id"));
				permissao.setPermissao_nome(rs.getString("permissao_nome"));
				permissao.setPermissao_status(rs.getInt("permissao_status"));
				permissoes.add(permissao);
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return permissoes;
	}
}
