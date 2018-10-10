package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Erro;

public class ErroDAO {
	Connection connection = ConnectionFactory.getConnection();

	public void inserir(Erro erro) {
		String sql = "INSERT INTO erro (erro_id, erro_nome, erro_descricao, erro_tipo, erro_prioridade, erro_status) VALUES (?, ?, ?, ?, ?, ?);";

		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, erro.getErro_id());
			ps.setString(2, erro.getErro_nome());
			ps.setString(3, erro.getErro_descricao());
			ps.setString(4, erro.getErro_tipo());
			ps.setInt(5, erro.getErro_prioridade());
			ps.setInt(6, erro.getErro_status());
			ps.execute();
			//JOptionPane.showMessageDialog(null, "INSERIDO COM SUCESSO!");
			ps.close();
		} catch (SQLException e) {
			//JOptionPane.showMessageDialog(null, "FALHOU!");
			e.printStackTrace();
		}
	}

	public void atualizar(Erro erro) {
		String sql = "UPDATE erro SET erro_nome = ?, erro_descricao = ?, erro_tipo = ?, erro_prioridade = ?, erro_status = ? WHERE erro_id = ?;";

		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, erro.getErro_nome());
			ps.setString(2, erro.getErro_descricao());
			ps.setString(3, erro.getErro_tipo());
			ps.setInt(4, erro.getErro_prioridade());
			ps.setInt(5, erro.getErro_status());
			ps.setInt(6, erro.getErro_id());
			ps.execute();
			//JOptionPane.showMessageDialog(null, "ATUALIZADO COM SUCESSO!");
			ps.close();
		} catch (SQLException e) {
			//JOptionPane.showMessageDialog(null, "FALHOU!");
			e.printStackTrace();
		}
	}

	public void excluir(int id) {
		String sql = "DELETE FROM erro WHERE erro_id = ?;";

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

	public List<Erro> listar() {
		String sql = "SELECT * FROM erro;";

		PreparedStatement ps;
		ResultSet rs;
		List<Erro> erros = new ArrayList<Erro>();
		try {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Erro erro = new Erro();
				erro.setErro_id(rs.getInt("erro_id"));
				erro.setErro_descricao(rs.getString("erro_nome"));
				erro.setErro_descricao(rs.getString("erro_descricao"));
				erro.setErro_descricao(rs.getString("erro_tipo"));
				erro.setErro_prioridade(rs.getInt("erro_prioridade"));
				erro.setErro_status(rs.getInt("erro_status"));
				erros.add(erro);
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return erros;
	}
}
