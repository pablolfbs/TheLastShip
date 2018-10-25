package projeto.centroOperacoes.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import projeto.centroOperacoes.modelo.AlocacaoEquipamento;
import projeto.centroOperacoes.modelo.Equipamento;
import projeto.centroOperacoes.modelo.Erro;

public class EquipamentoDAO {
	Connection connection = ConnectionFactory.getConnection();

	public void inserir(Equipamento equipamento, AlocacaoEquipamento alocacaoEquipamento, Erro erro) {
		String sql = "INSERT INTO equipamento (equipamento_id, equipamento_descricao, equipamento_status) VALUES (?, ?, ?);";

		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, equipamento.getEquipamento_id());
			ps.setString(2, equipamento.getEquipamento_descricao());
			ps.setInt(3, equipamento.getEquipamento_status());
			ps.execute();
			//JOptionPane.showMessageDialog(null, "INSERIDO COM SUCESSO!");
			ps.close();
		} catch (SQLException e) {
			//JOptionPane.showMessageDialog(null, "FALHOU!");
			e.printStackTrace();
		}
	}

	public void atualizar(Equipamento equipamento) {
		String sql = "UPDATE equipamento SET equipamento_descricao = ?, equipamento_status = ? WHERE equipamento_id = ?;";

		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, equipamento.getEquipamento_descricao());
			ps.setInt(2, equipamento.getEquipamento_status());
			ps.setInt(3, equipamento.getEquipamento_id());
			ps.execute();
			//JOptionPane.showMessageDialog(null, "ATUALIZADO COM SUCESSO!");
			ps.close();
		} catch (SQLException e) {
			//JOptionPane.showMessageDialog(null, "FALHOU!");
			e.printStackTrace();
		}
	}

	public void excluir(int id) {
		String sql = "DELETE FROM equipamento WHERE equipamento_id = ?;";

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

	public List<Equipamento> listar() {
		String sql = "SELECT * FROM equipamento;";

		Statement stmt;
		ResultSet rs;
		List<Equipamento> equipamentos = new ArrayList<Equipamento>();
		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Equipamento equipamento = new Equipamento();
				equipamento.setEquipamento_id(rs.getInt("equipamento_id"));
				equipamento.setEquipamento_descricao(rs.getString("equipamento_descricao"));
				equipamento.setEquipamento_status(rs.getInt("equipamento_status"));
				equipamentos.add(equipamento);
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return equipamentos;
	}
	
	public List<Equipamento> buscar(Integer equipamento_id) {
		String sql = "SELECT * FROM equipamento WHERE equipamento_id = " + equipamento_id;

		Statement stmt;
		ResultSet rs;
		List<Equipamento> equipamentos = new ArrayList<Equipamento>();
		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Equipamento equipamento = new Equipamento();
				equipamento.setEquipamento_id(rs.getInt("equipamento_id"));
				equipamento.setEquipamento_descricao(rs.getString("equipamento_descricao"));
				equipamento.setEquipamento_status(rs.getInt("equipamento_status"));
				equipamentos.add(equipamento);
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return equipamentos;
	}
}
