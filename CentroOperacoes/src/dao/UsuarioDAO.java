package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Usuario;

public class UsuarioDAO {
	
	Connection connection = ConnectionFactory.getConnection();

	public void inserir(Usuario usuario) {
		String sql = "INSERT INTO usuario (usuario_id, usuario_cpf, usuario_nome, usuario_sobrenome, usuario_funcao, usuario_login, usuario_senha, usuario_status) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";

		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, usuario.getUsuario_id());
			ps.setString(2, usuario.getUsuario_cpf());
			ps.setString(3, usuario.getUsuario_nome());
			ps.setString(4, usuario.getUsuario_sobrenome());
			ps.setString(5, usuario.getUsuario_funcao());
			ps.setString(6, usuario.getUsuario_login());
			ps.setString(7, usuario.getUsuario_senha());
			ps.setInt(8, usuario.getUsuario_status());
			ps.execute();
			//JOptionPane.showMessageDialog(null, "INSERIDO COM SUCESSO!");
			ps.close();
		} catch (SQLException e) {
			//JOptionPane.showMessageDialog(null, "FALHOU!");
			e.printStackTrace();
		}
	}

	public void atualizar(Usuario usuario) {
		String sql = "UPDATE usuario SET usuario_cpf = ?, usuario_nome = ?, usuario_sobrenome = ?, usuario_funcao = ?, usuario_login = ?, usuario_senha = ?, usuario_status = ? WHERE usuario_id = ?;";

		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, usuario.getUsuario_cpf());
			ps.setString(2, usuario.getUsuario_nome());
			ps.setString(3, usuario.getUsuario_sobrenome());
			ps.setString(4, usuario.getUsuario_funcao());
			ps.setString(5, usuario.getUsuario_login());
			ps.setString(6, usuario.getUsuario_senha());
			ps.setInt(7, usuario.getUsuario_status());
			ps.setInt(8, usuario.getUsuario_id());
			ps.execute();
			//JOptionPane.showMessageDialog(null, "ATUALIZADO COM SUCESSO!");
			ps.close();
		} catch (SQLException e) {
			//JOptionPane.showMessageDialog(null, "FALHOU!");
			e.printStackTrace();
		}
	}

	public void excluir(int id) {
		String sql = "DELETE FROM usuario WHERE usuario_id = ?;";

		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
			//JOptionPane.showMessageDialog(null, "DELETADO COM SUCESSO!");
			ps.close();
		} catch (SQLException e) {
			//JOptionPane.showMessageDialog(null, "FALHOU!");
			e.printStackTrace();
		}
	}

	public List<Usuario> listar() {
		String sql = "SELECT * FROM usuario;";

		PreparedStatement ps;
		ResultSet rs;
		List<Usuario> usuarios = new ArrayList<Usuario>();
		try {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setUsuario_id(rs.getInt("usuario_id"));
				usuario.setUsuario_cpf(rs.getString("usuario_cpf"));
				usuario.setUsuario_nome(rs.getString("usuario_nome"));
				usuario.setUsuario_sobrenome(rs.getString("usuario_sobrenome"));
				usuario.setUsuario_funcao(rs.getString("usuario_funcao"));
				usuario.setUsuario_login(rs.getString("usuario_login"));
				usuario.setUsuario_senha(rs.getString("usuario_senha"));
				usuario.setUsuario_status(rs.getInt("usuario_status"));
				usuarios.add(usuario);
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuarios;
	}
	
	public List<Usuario> buscarUsuario(String user_id) {
		
		String sql = "SELECT * FROM usuario where usuario_login=?;";
		PreparedStatement ps;
		ResultSet rs;
		List<Usuario> usuarios = new ArrayList<Usuario>();
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, user_id);
			rs = ps.executeQuery();
			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setUsuario_id(rs.getInt("usuario_id"));
				usuario.setUsuario_cpf(rs.getString("usuario_cpf"));
				usuario.setUsuario_nome(rs.getString("usuario_nome"));
				usuario.setUsuario_sobrenome(rs.getString("usuario_sobrenome"));
				usuario.setUsuario_funcao(rs.getString("usuario_funcao"));
				usuario.setUsuario_login(rs.getString("usuario_login"));
				usuario.setUsuario_senha(rs.getString("usuario_senha"));
				usuario.setUsuario_status(rs.getInt("usuario_status"));
				usuarios.add(usuario);
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuarios;
	}
}
