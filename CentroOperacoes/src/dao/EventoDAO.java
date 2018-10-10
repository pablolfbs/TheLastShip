package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Evento;

public class EventoDAO {
	Connection connection = ConnectionFactory.getConnection();

	public void inserir(Evento evento) {
		String sql = "INSERT INTO evento (evento_id, evento_data, evento_descricao, evento_status, evento_prioridade) VALUES (?, ?, ?, ?, ?);";

		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, evento.getEvento_id());
			// cast date só para tirar erro
			ps.setDate(2, (Date) evento.getEvento_data());
			ps.setString(3, evento.getEvento_descricao());
			ps.setInt(4, evento.getEvento_status());
			ps.setInt(5, evento.getEvento_prioridade());
			ps.execute();
			//JOptionPane.showMessageDialog(null, "INSERIDO COM SUCESSO!");
			ps.close();
		} catch (SQLException e) {
			//JOptionPane.showMessageDialog(null, "FALHOU!");
			e.printStackTrace();
		}
	}

	public void atualizar(Evento evento) {
		String sql = "UPDATE evento SET evento_nome = ?, evento_descricao = ?, evento_status, evento_prioridade = ? = ? WHERE evento_id = ?;";

		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(sql);
			// cast date só para tirar erro
			ps.setDate(1, (Date) evento.getEvento_data());
			ps.setString(2, evento.getEvento_descricao());
			ps.setInt(3, evento.getEvento_status());
			ps.setInt(4, evento.getEvento_prioridade());
			ps.setInt(5, evento.getEvento_id());
			ps.execute();
			//JOptionPane.showMessageDialog(null, "ATUALIZADO COM SUCESSO!");
			ps.close();
		} catch (SQLException e) {
			//JOptionPane.showMessageDialog(null, "FALHOU!");
			e.printStackTrace();
		}
	}

	public void excluir(int id) {
		String sql = "DELETE FROM evento WHERE evento_id = ?;";

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

	public List<Evento> listar() {
		String sql = "SELECT * FROM evento;";

		PreparedStatement ps;
		ResultSet rs;
		List<Evento> eventos = new ArrayList<Evento>();
		try {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Evento evento = new Evento();
				evento.setEvento_id(rs.getInt("evento_id"));
				evento.setEvento_data(rs.getDate("evento_data"));
				evento.setEvento_descricao(rs.getString("evento_descricao"));
				evento.setEvento_status(rs.getInt("evento_status"));
				evento.setEvento_prioridade(rs.getInt("evento_prioridade"));
				eventos.add(evento);
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return eventos;
	}

}
