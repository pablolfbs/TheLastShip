package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Navio;
public class NavioDAO {
	Connection connection = ConnectionFactory.getConnection();

	public void inserir(Navio navio) {
		String sql = "INSERT INTO navio (navio_id, navio_nome, navio_status) VALUES (?, ?, ?);";

		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, navio.getNavio_id());
			ps.setString(2, navio.getNavio_nome());
			ps.setInt(3, navio.getNavio_status());
			ps.execute();
			//JOptionPane.showMessageDialog(null, "INSERIDO COM SUCESSO!");
			ps.close();
		} catch (SQLException e) {
			//JOptionPane.showMessageDialog(null, "FALHOU!");
			e.printStackTrace();
		}
	}

	public void atualizar(Navio navio) {
		String sql = "UPDATE navio SET navio_nome = ?, navio_status = ? WHERE navio_id = ?;";

		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, navio.getNavio_nome());
			ps.setInt(2, navio.getNavio_status());
			ps.setInt(3, navio.getNavio_id());
			ps.execute();
			//JOptionPane.showMessageDialog(null, "ATUALIZADO COM SUCESSO!");
			ps.close();
		} catch (SQLException e) {
			//JOptionPane.showMessageDialog(null, "FALHOU!");
			e.printStackTrace();
		}
	}

	public void excluir(int id) {
		String sql = "DELETE FROM navio WHERE navio_id = ?;";

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

	public List<Navio> listar() {
		String sql = "SELECT * FROM navio;";

		PreparedStatement ps;
		ResultSet rs;
		List<Navio> navios = new ArrayList<Navio>();
		try {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Navio navio = new Navio();
				navio.setNavio_id(rs.getInt("navio_id"));
				navio.setNavio_nome(rs.getString("navio_nome"));
				navio.setNavio_status(rs.getInt("navio_status"));
				navios.add(navio);
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return navios;
	}

}
