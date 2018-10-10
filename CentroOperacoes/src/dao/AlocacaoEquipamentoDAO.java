package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.AlocacaoEquipamento;

public class AlocacaoEquipamentoDAO {
	
	Connection connection = ConnectionFactory.getConnection();

	public void inserir(AlocacaoEquipamento alocacaoequipamento) {
		String sql = "INSERT INTO alocacaoequipamento (alocacaoequipamento_id, alocacaoequipamento_zona, alocacaoequipamento_status)   VALUES (?, ?, ?);";

		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, alocacaoequipamento.getAlocacaoequipamento_id());
			ps.setString(2, alocacaoequipamento.getAlocacaoequipamento_zona());
			ps.setInt(3, alocacaoequipamento.getAlocacaoequipamento_status());
			ps.execute();
			//JOptionPane.showMessageDialog(null, "INSERIDO COM SUCESSO!");
			// ps.close();
		} catch (SQLException e) {
			//JOptionPane.showMessageDialog(null, "FALHOU!");
			e.printStackTrace();
		}
	}

	public void atualizar(AlocacaoEquipamento alocacaoequipamento) {
		String sql = "UPDATE alocacaoequipamento SET alocacaoequipamento_zona = ?, alocacaoequipamento_status = ? WHERE id = ?;";

		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, alocacaoequipamento.getAlocacaoequipamento_zona());
			ps.setInt(2, alocacaoequipamento.getAlocacaoequipamento_status());
			ps.setInt(3, alocacaoequipamento.getAlocacaoequipamento_id());
			ps.execute();
			//JOptionPane.showMessageDialog(null, "ATUALIZADO COM SUCESSO!");
			ps.close();
		} catch (SQLException e) {
			//JOptionPane.showMessageDialog(null, "FALHOU!");
			e.printStackTrace();
		}
	}

	public void excluir(int id) {
		String sql = "DELETE FROM alocacaoequipamento WHERE alocacaoequipamento_id = ?;";

		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			//JOptionPane.showMessageDialog(null, "FALHOU!");
			e.printStackTrace();
		}
	}

	public List<AlocacaoEquipamento> listar() {
		String sql = "SELECT * FROM alocacaoequipamento INNER JOIN navio ON alocacaoequipamento.alocacaoequipamento_id = navio.navio_id;";

		PreparedStatement ps;
		ResultSet rs;
		List<AlocacaoEquipamento> alocacaoequipamentos = new ArrayList<AlocacaoEquipamento>();
		try {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				AlocacaoEquipamento alocacaoequipamento = new AlocacaoEquipamento();
				alocacaoequipamento.setAlocacaoequipamento_id(rs.getInt("alocacaoequipamento_id"));
				alocacaoequipamento.setAlocacaoequipamento_zona(rs.getString("alocacaoequipamento_zona"));
				alocacaoequipamento.setAlocacaoequipamento_status(rs.getInt("alocacaoequipamento_status"));
				alocacaoequipamentos.add(alocacaoequipamento);
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alocacaoequipamentos;
	}
}
