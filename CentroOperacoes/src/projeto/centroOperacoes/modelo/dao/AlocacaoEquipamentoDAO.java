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
import projeto.centroOperacoes.modelo.Evento;
import projeto.centroOperacoes.modelo.Navio;

public class AlocacaoEquipamentoDAO {
	
	Connection connection = ConnectionFactory.getConnection();

	public void inserir(AlocacaoEquipamento alocacaoequipamento, Navio navio, Equipamento equipamento, Evento evento, Erro erro) {
		String sql = "INSERT INTO alocacaoequipamento (alocacaoequipamento_id, alocacaoequipamento_zona, alocacaoequipamento_status, navio_navio_id, equipamento_equipamento_id, evento_evento_id, erro_erro_id)   VALUES (?, ?, ?, ?, ?, ?, ?);";

		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, alocacaoequipamento.getAlocacaoequipamento_id());
			ps.setString(2, alocacaoequipamento.getAlocacaoequipamento_zona());
			ps.setInt(3, alocacaoequipamento.getAlocacaoequipamento_status());
			ps.setInt(4, navio.getNavio_id());
			ps.setInt(5, equipamento.getEquipamento_id());
			ps.setInt(6, evento.getEvento_id());
			ps.setInt(7, erro.getErro_id());
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
		String sql = "UPDATE alocacaoequipamento SET alocacaoequipamento_status = 0 WHERE alocacao_equipamento_id = ?;";

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
		String sql = "SELECT * FROM alocacaoequipamento;";

		Statement stmt;
		ResultSet rs;
		List<AlocacaoEquipamento> alocacaoequipamentos = new ArrayList<AlocacaoEquipamento>();
		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				AlocacaoEquipamento alocacaoequipamento = new AlocacaoEquipamento();
				alocacaoequipamento.setAlocacaoequipamento_id(rs.getInt("alocacaoequipamento_id"));
				alocacaoequipamento.setAlocacaoequipamento_zona(rs.getString("alocacaoequipamento_zona"));
				alocacaoequipamento.setAlocacaoequipamento_status(rs.getInt("alocacaoequipamento_status"));
				alocacaoequipamentos.add(alocacaoequipamento);
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alocacaoequipamentos;
	}
	
	public List<AlocacaoEquipamento> buscar(Integer alocacaoEquipamento_id) {
		String sql = "SELECT * FROM alocacaoequipamento WHERE alocacaoequipamento_id = " + alocacaoEquipamento_id;

		Statement stmt;
		ResultSet rs;
		List<AlocacaoEquipamento> alocacaoequipamentos = new ArrayList<AlocacaoEquipamento>();
		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				AlocacaoEquipamento alocacaoequipamento = new AlocacaoEquipamento();
				alocacaoequipamento.setAlocacaoequipamento_id(rs.getInt("alocacaoequipamento_id"));
				alocacaoequipamento.setAlocacaoequipamento_zona(rs.getString("alocacaoequipamento_zona"));
				alocacaoequipamento.setAlocacaoequipamento_status(rs.getInt("alocacaoequipamento_status"));
				alocacaoequipamentos.add(alocacaoequipamento);
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alocacaoequipamentos;
	}
}
